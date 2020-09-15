package de.dfki.cos.basys.common.component.util;

import java.io.IOException;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;


public class CommUtils {

	public static ArrayList<String> serverList = new ArrayList<>(Arrays.asList("basys-lnv-1", "lns-90165.sb.dfki.de", "localhost" ));
	
	public static String getPreferredDockerStack() throws UnknownHostException {
		
		for (int i = 0; i < serverList.size(); i++) {

			try {
				InetAddress address = InetAddress.getByName(serverList.get(i));
				if (address.isReachable(10000)) {
					return address.getHostName();
				}
			} catch (IOException e) {
				// do nothing
			}
		}
		
		throw new UnknownHostException("Cannot reach the BaSys 4.0 middleware");
		
	}
	
    public static boolean isServerListening(String serverHost, int serverPort, int timeoutMs) {
        try (Socket s = new Socket()) {
            s.connect(new InetSocketAddress(serverHost, serverPort), timeoutMs);
            boolean result = s.isConnected();
            s.close();
            return result;
        } catch (Exception e) {  
            //String errMsg = String.format("Can't connect to [%s:%d] (timeout was %d ms) - %s, - %s", serverHost, serverPort, timeoutMs, exDetails, e.getMessage());
            //throw new IllegalStateException(errMsg);
        }
        return false;
    }
	
}
