package de.dfki.iui.basys.common.emf.computation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class Computation {

	protected Map<EObject, Map<EObject, EObject>> alreadyHandled = new HashMap<EObject, Map<EObject, EObject>>();

	protected void addToAlreadyHandled(EObject co, EObject bg, EObject result) {
		Map<EObject, EObject> targetMap;
		if (alreadyHandled.containsKey(co)) {
			targetMap = alreadyHandled.get(co);
		} else {
			targetMap = new HashMap<EObject, EObject>();
			alreadyHandled.put(co, targetMap);
		}
		targetMap.put(bg, result);
	}

	protected EObject resultFromAlreadyHandled(EObject co, EObject bg) {
		if (alreadyHandled.containsKey(co)) {
			if (alreadyHandled.get(co).containsKey(bg))
				return alreadyHandled.get(co).get(bg);
		}
		return null;
	}

	protected abstract Object _compute(Object co, Object bg);

	public static Set<EClass> getLeastUpperBound(EObject o1, EObject o2, boolean strictSubsumption) {
		return getLeastUpperBound(o1.eClass(), o2.eClass(), strictSubsumption);
	}

	public static Set<EClass> getLeastUpperBound(EClass c1, EClass c2, boolean strictSubsumption) {
		return _getLeastUpperBound(c1, c2, new HashSet<EClass>(), strictSubsumption);
	}

	public static Set<EStructuralFeature> getLeastUpperBoundFeatures(EObject o1, EObject o2, boolean strictSubsumption) {
		return getLeastUpperBoundFeatures(o1.eClass(), o2.eClass(), strictSubsumption);
	}

	public static Set<EStructuralFeature> getLeastUpperBoundFeatures(EClass c1, EClass c2, boolean strictSubsumption) {
		Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		Set<EClass> lub = getLeastUpperBound(c1, c2, strictSubsumption);
		for (EClass c : lub) {
			features.addAll(c.getEAllStructuralFeatures());
		}
		return features;
	}

	protected static Set<EClass> _getLeastUpperBound(EClass c1, EClass c2, Set<EClass> result, boolean strictSubsumption) {

		if (c1 == c2) {
			result.add(c1);
			return result;
		}
		if (c1.isSuperTypeOf(c2)) {
			result.add(c1);
			return result;
		}
		if (c2.isSuperTypeOf(c1)) {
			result.add(c2);
			return result;
		}

		if (strictSubsumption)
			return result;

		// jetzt liegen c1 und c2 nicht mehr auf einem gemeinsamen pfad.

		EList<EClass> s1 = c1.getEAllSuperTypes();
		EList<EClass> s2 = c2.getEAllSuperTypes();

		result.addAll(s1);
		result.retainAll(s2);

		Set<EClass> remove = new HashSet<EClass>();

		// now filter all supertypes that are also supertype of another
		// supertype in the set
		for (EClass r2 : result) {
			if (remove.contains(r2)) {
				continue;
			}
			for (EClass r1 : result) {
				if (r1 == r2) {
					continue;
				}
				if (remove.contains(r1)) {
					continue;
				}

				if (r1.isSuperTypeOf(r2)) {
					remove.add(r1);
					continue;
				}
			}
		}

		result.removeAll(remove);

		return result;
	}

	// public class Result implements Comparable<Result> {
	//
	// private Object covering = null;
	// private Object background = null;
	// private Object result = null;
	//
	// private double score = 0;
	//
	// public Object getCovering() {
	// return covering;
	// }
	//
	// public void setCovering(Object covering) {
	// this.covering = covering;
	// }
	//
	// public Object getBackground() {
	// return background;
	// }
	//
	// public void setBackground(Object background) {
	// this.background = background;
	// }
	//
	// public Object getResult() {
	// return result;
	// }
	//
	// public void setResult(Object result) {
	// this.result = result;
	// }
	//
	// public double getScore() {
	// return score;
	// }
	//
	// public void setScore(double score) {
	// this.score = score;
	// }
	//
	// @Override
	// public int compareTo(Result arg0) {
	// return Double.compare(getScore(), arg0.getScore());
	// }
	// }

	// /**
	// * This method applies the given computation and yields a set of
	// * <code>co</code> objects that could be used in a computation with a
	// * <code>bg</code> object. In case of success there are no 2 different
	// * <code>co</code> objects that were used in a computation with the same
	// * <code>bg</code> object.<BR>
	// * For each <code>bg</code> object there must be a <code>co</code> object,
	// * i.e. <code>bg.size() <= co.size()</code> must be true. Depending on the
	// * computation exchange the roles if possible and needed, i.e. call
	// * <code>compute(bg, co)</code> instead of <code>compute(co, bg)</code>.
	// * <BR>
	// * Whenever the computation on two objects <code>co</code> and
	// * <code>bg</code> is needed the method
	// * {@link Computation#apply(Object, Object)} is called. Therefore
	// subclasses
	// * have to overwrite that method whenever
	// * {@link Computation#compute(List, List, Computation)} is used.
	// *
	// * @param co
	// * @param bg
	// * @return
	// */
	// protected List<Object> compute(List<?> co, List<?> bg) {
	// int bg_size = bg.size(), co_size = co.size();
	// if (bg_size > co_size) {
	// List<?> temp = co;
	// co = bg;
	// bg = temp;
	// bg_size = bg.size();
	// co_size = co.size();
	// }
	// if (bg_size == 0 && co_size == 0)
	// return new ArrayList<Object>();
	//
	// if (bg_size == 0) {
	// List<Object> result = new ArrayList<Object>(co_size);
	// for (Object o : co) {
	// if (o instanceof EObject)
	// result.add(EcoreUtil.copy((EObject) o));
	// else
	// result.add(o);
	// }
	// return result;
	// }
	//
	// Object dummy = new Object();
	// Integer[] tmp = new Integer[bg_size];
	// Arrays.fill(tmp, -1);
	//
	// // 'table' is used to store the intermediate values. table[i][j] == o
	// // iff o = apply(co.get( j ), bg.get( i ))
	// Object[][] table = new Object[bg_size][co_size];
	// List<Integer> curPos = Arrays.asList(tmp);
	//
	// // each subset contains the 'real positions' of co objects
	// // TODO muss noch �berarbeitet werden
	// for (SubS subset : new PowS(bg_size, co_size)) {
	// for (int bgPos = 0; bgPos < bg_size;) {
	// int cp = curPos.get(bgPos);
	// for (int j = cp + 1; j < bg_size;) {
	// int coPos = subset.numbers[j];
	// Object o = table[bgPos][coPos];
	// if (o == null) {
	// table[bgPos][coPos] = (o = _compute(co.get(coPos), bg.get(bgPos))) ==
	// null ? dummy : o;
	// } else if (o == dummy) {
	// // false
	// j++;
	// } else {
	// // true
	// if (curPos.contains(j)) {
	// // it is already used by another bg object
	// j++;
	// } else {
	// curPos.set(bgPos, j);
	// j = bg_size; // stop the looping
	// }
	// }
	// }
	//
	// if (curPos.get(bgPos) == cp) {
	// // nothing changed, backtracking needed:
	// if (--bgPos == -1) {
	// // try the next subset
	// curPos = Arrays.asList(tmp);
	// break;
	// }
	// } else {
	// if (++bgPos == bg_size) {
	// // solution found at the last bg object
	// List<Object> result = new ArrayList<Object>(bg_size);
	// for (int i = 0; i < bg_size; i++) {
	// result.add(co.get(subset.numbers[curPos.get(i)]));
	// }
	// return result;
	// }
	// }
	// }
	// }
	// return null;
	// }
	//
	// /**
	// * Represents a subset of the power set <code>{0,1, .. , m}</code> (where
	// * <code>m</code> is given as constructor parameter). If the given
	// * constructor parameter <code>n</code> is unequal to <code>m</code> the
	// * PowS yields only elements of the power set which have the size
	// * <code>n</code>.
	// */
	// static class PowS implements Iterable<SubS>, Iterator<SubS> {
	// private int n = 0, m = 0, cur = 0;
	// private String ss = "";
	//
	// public PowS(int n, int m) {
	// this.n = n;
	// this.m = m;
	// for (int i = 0; i < n; i++) {
	// ss += "1";
	// }
	// cur = Integer.parseInt(ss, 2);
	// }
	//
	// @Override
	// public boolean hasNext() {
	// return ss != null && ss.length() <= m;
	// }
	//
	// @Override
	// public SubS next() {
	// if (ss == null || ss.length() > m)
	// throw new RuntimeException("No further elements available.");
	// SubS res = new SubS(ss, n);
	// boolean found = false;
	// while (ss.length() <= m) {
	// ss = new
	// StringBuffer(Integer.toBinaryString(++cur)).reverse().toString();
	// if (ss.length() <= m) {
	// int num = 0;
	// for (char c : ss.toCharArray()) {
	// if (c == '1') {
	// num++;
	// }
	// }
	//
	// // the following addition of a suffix must not be in the
	// // next if-conditional since
	// // the length
	// char[] sfx = new char[m - ss.length()];
	// Arrays.fill(sfx, '0');
	// ss += new String(sfx);
	//
	// if (found = num == n) {
	// break;
	// }
	// }
	// }
	// if (!found) {
	// ss = null;
	// }
	// return res;
	// }
	//
	// @Override
	// public void remove() {
	// throw new RuntimeException("The iterator class 'PS' does not implement
	// the iterator method 'public void remove()' yet.");
	// }
	//
	// @Override
	// public Iterator<SubS> iterator() {
	// return this;
	// }
	//
	// }
	//
	// /**
	// * SubS represents a set of integers and is used by PowS.
	// */
	// static class SubS implements Iterable<Integer>, Iterator<Integer> {
	// public int[] numbers;
	// public int pos = 0;
	// private final int n;
	//
	// public SubS(String ss, int n) {
	// this.n = n;
	// numbers = new int[n];
	// for (int j = 0, i = 0, l = ss.length(); i < l; i++) {
	// if (ss.charAt(i) == '1') {
	// numbers[j++] = i;
	// }
	// }
	// }
	//
	// @Override
	// public boolean hasNext() {
	// return pos < n;
	// }
	//
	// @Override
	// public Integer next() {
	// return numbers[pos++];
	// }
	//
	// @Override
	// public void remove() {
	// throw new RuntimeException("The iterator class 'SS' does not implement
	// the iterator method 'public void remove()' yet.");
	// }
	//
	// @Override
	// public Iterator<Integer> iterator() {
	// return SubS.this;
	// }
	//
	// }
}
