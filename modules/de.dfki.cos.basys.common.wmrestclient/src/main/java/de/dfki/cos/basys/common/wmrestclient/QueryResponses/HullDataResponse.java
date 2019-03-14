/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.cos.basys.common.wmrestclient.QueryResponses;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame.FrameType;
import de.dfki.cos.basys.common.wmrestclient.dto.RivetPosition.State;
import de.dfki.cos.basys.common.wmrestclient.dto.Sector.SectorEnum;

/**
 *
 * @author tospie
 */
public class HullDataResponse {
    public String rivetUri;
    public String frameUri;
    public String rivetId;
    public String frameId;
    public int frameIndex;
    public int index;
    public State status;
    public String statusUri;
    public SectorEnum hullRegion;
    public FrameType frameType;
}
