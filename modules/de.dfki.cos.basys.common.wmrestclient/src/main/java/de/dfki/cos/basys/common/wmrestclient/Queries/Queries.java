/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.cos.basys.common.wmrestclient.Queries;

/**
 *
 * @author tosp01
 */
public class Queries {

    public static String AllRivetPositions = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + "SELECT ?rivetUri ?id ?index WHERE {\n"
	    + "?rivetUri dct:hasPart ?rivetComponent ;\n"
	    + "dct:identifier ?id .\n"
	    + "?rivetComponent dct:identifier \"rivetposition\"^^<xsd:string> ;"
	    + "dct:hasPart ?indexAttr ."
	    + "?indexAttr dct:identifier 'index'^^<xsd:string>;"
	    + "rdf:value ?index ."
	    + "FILTER isLiteral(?index)"
	    + "}";

    public static String getHulls = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + "SELECT DISTINCT ?hullUri ?hullId WHERE { "
	    + "?hullUri dct:hasPart ?hullComponent ;"
	    + "dct:identifier ?hullId ."
	    + "?hullComponent dct:identifier 'hull'^^<xsd:string> ."
	    + "}";

    public static String getHullById = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + "SELECT DISTINCT ?hullUri WHERE { "
	    + "?hullUri dct:hasPart ?hullComponent ;"
	    + "dct:identifier '%s'^^<xsd:string> ."
	    + "?hullComponent dct:identifier 'hull'^^<xsd:string> ."
	    + "}";

    public static String SingleFrameById = "prefix ldp: <http://www.w3.org/ns/ldp#> "
	    + "prefix dct: <http://purl.org/dc/terms/> "
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
	    + "SELECT DISTINCT ?id ?index ?type ?hullregion ?hullId WHERE { "
            + ""
            + "?hullUri dct:hasPart ?hullComponent ;"
            + "dct:identifier ?hullId ."
            + ""
            + "?hullComponent dct:identifier 'hull'^^<xsd:string>;"
            + "dct:hasPart ?framesAttr. "
            + ""
            + "?framesAttr dct:identifier 'frames'^^<xsd:string>;"
            + "ldp:contains ?frameUri ."
            + ""
            + "?frameUri dct:identifier '%s'^^<xsd:string> ;"
            + "dct:identifier ?id ;"
            + "dct:hasPart ?frameComponent ."
            + ""
            + "?frameComponent dct:identifier 'frame'^^<xsd:string> ;"
            + "dct:hasPart ?indexAttr;"
            + "dct:hasPart ?typeAttr;"
            + "dct:hasPart ?hullregionAttr ."
            + ""
            + "?indexAttr dct:identifier 'index'^^<xsd:string> ;"
            + "rdf:value ?index ."
            + ""
            + "?typeAttr dct:identifier 'type'^^<xsd:string>;"
            + "rdf:value ?type ."
            + ""
            + "?hullregionAttr dct:identifier 'hullregion'^^<xsd:string>;"
            + "rdf:value ?hullregion ."
            + ""
            + "FILTER isLiteral(?index)"
            + "FILTER isLiteral(?type)"
            + "FILTER isLiteral(?hullregion)"
            + "}";

    public static String FramesInHull = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + "SELECT DISTINCT ?id ?index ?type ?hullregion ?hullId WHERE {\n"
	    + ""
	    + "?hullUri dct:hasPart ?hullComponent ;"
	    + "  dct:identifier ?hullId;"
            + "  dct:identifier '%1$s'^^<xsd:string> ."
	    + "?hullComponent dct:identifier 'hull'^^<xsd:string> ;"
	    + "  dct:hasPart ?framesCollection ."
	    + "?framesCollection dct:identifier 'frames'^^<xsd:string> ;"
	    + "  ldp:contains ?frameUri ."
	    + ""
	    + "?frameUri dct:hasPart ?frameComponent ;"
	    + "  dct:identifier ?id .\n"
	    + "?frameComponent dct:identifier \"frame\"^^<xsd:string> ;"
	    + "  dct:hasPart ?indexAttr ;"
	    + "  dct:hasPart ?typeAttr ;"
	    + "  dct:hasPart ?regionAttr ."
	    + "?indexAttr dct:identifier 'index'^^<xsd:string>;"
	    + "  %2$s"
            + "  rdf:value ?index ."
	    + "?typeAttr dct:identifier 'type'^^<xsd:string>; "
	    + "  rdf:value ?type ."
	    + "?regionAttr dct:identifier 'hullregion'^^<xsd:string>; "
	    + "  rdf:value ?hullregion ."
	    + ""
	    + "FILTER isLiteral(?index)"
	    + "FILTER isLiteral(?type)"
	    + "FILTER isLiteral(?hullregion)"
	    + "}";

    public static String RivetPositionsInFrame = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + "SELECT DISTINCT ?rivetUri ?id ?index WHERE {"
	    + "?frameUri dct:hasPart ?frameComponent ;"
	    + "	 dct:identifier '%s'^^<xsd:string> ."
	    + ""
	    + "?frameComponent dct:identifier 'frame'^^<xsd:string> ;"
	    + "  dct:hasPart ?rivetPositionAttribute ."
	    + ""
	    + "?rivetPositionAttribute dct:identifier 'rivetPositions'^^<xsd:string> ;"
	    + "  ldp:contains ?rivetUri ."
	    + ""
	    + "?rivetUri dct:hasPart ?rivetComponent;"
	    + "  dct:identifier ?id ."
	    + ""
	    + "?rivetComponent dct:identifier 'rivetposition'^^<xsd:string> ;"
	    + "  dct:hasPart ?indexAttr ."
	    + ""
	    + "?indexAttr dct:identifier 'index'^^<xsd:string> ;"
	    + "  rdf:value ?index ."
	    + ""
	    + "FILTER isLiteral(?index)"
	    + "}";

    public static String SinlgeRivetPositionById = "prefix ldp: <http://www.w3.org/ns/ldp#>"
	    + "prefix dct: <http://purl.org/dc/terms/>"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
	    + "SELECT DISTINCT ?rivetUri ?index ?id WHERE {"
            + ""
	    + "?rivetUri dct:hasPart ?rivetComponent ;"
	    + "dct:identifier ?id; "
            + "dct:identifier '%s'^^<xsd:string> ."
            + ""
	    + "?rivetComponent dct:identifier 'rivetposition'^^<xsd:string>;"
	    + "dct:hasPart ?indAttr ."
            + ""
	    + "?indAttr dct:identifier 'index'^^<xsd:string> ;"
	    + "rdf:value ?index ."
            + ""
            + "FILTER isLiteral(?id)"
            + "FILTER isLiteral(?index)"
	    + "}";

    public static String RivetPositionState = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + "SELECT DISTINCT ?state ?stateUri WHERE { "
	    + "?riveturi dct:hasPart ?rivetPositionComponent ;"
	    + "dct:identifier \"%s\"^^<xsd:string> ."
	    + "?rivetPositionComponent dct:identifier \"rivetposition\"^^<xsd:string> ;"
	    + "dct:hasPart ?statusAttribute ."
	    + "?statusAttribute dct:identifier \"status\"^^<xsd:string> ;\n"
	    + "rdf:value ?state ;\n"
	    + "rdf:value ?stateUri ."
	    + "FILTER isLiteral(?state)\n"
	    + "FILTER isUri(?stateUri)\n"
	    + "}";

    public static String RivetPositionParentFrame = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + "SELECT DISTINCT ?id ?index ?type WHERE { "
	    + "?frameUri dct:hasPart ?frameComponent;"
	    + "dct:identifier ?id ."
	    + "?frameComponent dct:identifier \"frame\"^^<xsd:string> ;"
	    + "dct:hasPart ?indexAttr ;"
	    + "dct:hasPart ?rivetCollection ;"
	    + "dct:hasPart ?frametypeAttr ."
	    + "?rivetCollection dct:identifier \"rivetPositions\"^^<xsd:string>; "
	    + "ldp:contains <%s>."
	    + "?indexAttr dct:identifier \"index\"^^<xsd:string> ;"
	    + "rdf:value ?index ."
	    + "?typeAttr dct:identifier \"type\"^^<xsd:string> ;"
	    + "rdf:value ?type ."
	    + "FILTER isLiteral(?index)"
	    + "FILTER isLiteral(?type)"
	    + "}";


    public static String SingleRivetByFrameAndRivetIndex = "prefix ldp: <http://www.w3.org/ns/ldp#>"
	    + "prefix dct: <http://purl.org/dc/terms/>"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
	    + "SELECT DISTINCT ?rivetUri ?id ?index WHERE {"
            + "?hullUri dct:identifier '%1$s'^^<xsd:string> ;"
            + "dct:hasPart ?hullComponent ."
            + ""
            + "?hullComponent dct:identifier 'hull'^^<xsd:string> ;"
            + "dct:hasPart ?framesAttribute."
            + ""
            + "?framesAttribute dct:identifier 'frames'^^<xsd:string>;"
            + "ldp:contains ?frameUri ."
            + ""
            + "?frameUri dct:hasPart ?frameComponent ."
            + ""
            + "?frameComponent dct:identifier 'frame'^^<xsd:string> ;"
            + "dct:hasPart ?rivetPositionsAttr;"
            + "dct:hasPart ?frameIndexAttr ."
            + ""
            + "?frameIndexAttr dct:identifier 'index'^^<xsd:string>;"
            + "rdf:value '%2$d'^^<xsd:attributeValue> ."
            + "?rivetPositionsAttr dct:identifier 'rivetPositions'^^<xsd:string> ;"
            + "ldp:contains ?rivetUri ."
            + ""
            + "?rivetUri dct:hasPart ?rivetComponent; "
            + "dct:identifier ?id ."
            + ""
            + "?rivetComponent dct:identifier 'rivetposition'^^<xsd:string> ;"
            + "dct:hasPart ?rivetIndexAttr ."
            + ""
            + "?rivetIndexAttr dct:identifier 'index'^^<xsd:string> ;"
            + "rdf:value ?index; "
            + "rdf:value '%3$d'^^<xsd:attributeValue> ."
            + ""
            + "FILTER isLiteral(?index)"
            + "}";

    public static String ByParentFrameIndexAndState = "prefix ldp: <http://www.w3.org/ns/ldp#>"
	    + "prefix dct: <http://purl.org/dc/terms/>"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
	    + "SELECT ?rivetUri ?id ?index WHERE {"
            + "?hullUri dct:identifier '%1$s'^^<xsd:string> ;"
            + "dct:hasPart ?hullComponent ."
            + ""
            + "?hullComponent dct:identifier 'hull'^^<xsd:string> ;"
            + "dct:hasPart ?framesAttribute."
            + ""
            + "?framesAttribute dct:identifier 'frames'^^<xsd:string>;"
            + "ldp:contains ?frameUri ."
            + ""
            + "?frameUri dct:hasPart ?frameComponent ."
            + ""
            + "?frameComponent dct:identifier 'frame'^^<xsd:string> ;"
            + "dct:hasPart ?rivetPositionsAttr;"
            + "dct:hasPart ?frameIndexAttr ."
            + ""
            + "?frameIndexAttr dct:identifier 'index'^^<xsd:string>;"
            + "rdf:value '%2$d'^^<xsd:attributeValue> ."
            + "?rivetPositionsAttr dct:identifier 'rivetPositions'^^<xsd:string> ;"
            + "ldp:contains ?rivetUri ."
            + ""
            + "?rivetUri dct:hasPart ?rivetComponent; "
            + "dct:identifier ?id ."
            + ""
            + "?rivetComponent dct:identifier 'rivetposition'^^<xsd:string> ;"
            + "dct:hasPart ?rivetIndexAttr ;"
            + "dct:hasPart ?stateAttr ."
            + ""
            + "?rivetIndexAttr dct:identifier 'index'^^<xsd:string> ;"
            + "rdf:value ?index ."
            + ""
            + "?stateAttr dct:identifier 'status'^^<xsd:string> ;"
            + "rdf:value '%3$s'^^<xsd:attributeValue> ."
            + ""
            + "FILTER isLiteral(?index)"
            + "}"
            + "LIMIT %4$d";

    public static String BySector = "prefix ldp: <http://www.w3.org/ns/ldp#>\n"
	    + "prefix dct: <http://purl.org/dc/terms/>\n"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	    + ""
            + "SELECT ?rivetUri ?id ?index WHERE {"
	    + ""
            + "?rivetUri dct:hasPart ?rivetComponent ;"
	    + "dct:identifier ?id ."
	    + ""
            + "?rivetComponent dct:identifier 'rivetposition'^^<xsd:string>;"
	    + "dct:hasPart ?indAttr;"
	    + "dct:hasPart ?sectorAttr ."
	    + "?indAttr dct:identifier 'index'^^<xsd:string> ;"
	    + "rdf:value ?index ."
	    + "?sectorAttr dct:identifier 'sector'^^<xsd:string>;"
	    + "rdf:value '%s'^^<xsd:attributeValue> ."
	    + "FILTER isLiteral(?index)"
	    + "}";

    public static String BySectorAndState = "prefix ldp: <http://www.w3.org/ns/ldp#>"
	    + "prefix dct: <http://purl.org/dc/terms/>"
	    + "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
	    + "SELECT DISTINCT ?rivetUri ?id ?index WHERE {"
            + ""
            + "?hullUri dct:identifier '%1$s'^^<xsd:string> ;"
            + "dct:hasPart ?hullComponent ."
            + ""
            + "?hullComponent dct:identifier 'hull'^^<xsd:string> ;"
            + "dct:hasPart ?framesAttribute."
            + ""
            + "?framesAttribute dct:identifier 'frames'^^<xsd:string>;"
            + "ldp:contains ?frameUri ."
            + ""
            + "?rivetUri dct:hasPart ?rivetComponent ;"
	    + "dct:identifier ?id ."
	    + ""
            + "?rivetComponent dct:identifier 'rivetposition'^^<xsd:string>;"
	    + "dct:hasPart ?indAttr;"
	    + "dct:hasPart ?stateAttr;"
	    + "dct:hasPart ?sectorAttr ."
	    + ""
            + "?indAttr dct:identifier 'index'^^<xsd:string> ;"
	    + "rdf:value ?index ."
	    + ""
            + "?sectorAttr dct:identifier 'sector'^^<xsd:string>;"
	    + "rdf:value '%2$s'^^<xsd:attributeValue> ."
	    + "?stateAttr dct:identifier 'status'^^<xsd:string>;"
	    + "rdf:value '%3$s'^^<xsd:attributeValue> ."
	    + ""
            + "?frameUri dct:hasPart ?frameComponent ."
	    + "?frameComponent dct:identifier 'frame'^^<xsd:string> ; "
	    + "dct:hasPart ?frameIndex ;"
	    + "dct:hasPart ?rivetCollection ."
            + ""
	    + "?rivetCollection dct:identifier 'rivetPositions'^^<xsd:string>;"
	    + "ldp:contains ?rivetUri ."
	    + ""
            + "?frameIndex dct:identifier 'index'^^<xsd:string> ;"
	    + "rdf:value ?frameIndexValue ."
	    + ""
            + "FILTER isLiteral(?index)"
	    + "FILTER isLiteral(?frameIndexValue)"
	    + "}"
	    + "ORDER BY(?frameIndexValue)"
	    + "LIMIT %4$d";
}
