package app;

import org.jnetpcap.packet.JPacket;
import org.jnetpcap.protocol.tcpip.Http;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Created by jap on 4/8/2017.
 * Grab URLs that were visited by user
 */
public class infoHttp extends Packets{
    public infoHttp(){}

    public HashSet<String> packets(int x){
        ArrayList<JPacket> packets = getPackets();
        Http http = new Http();
        HashSet<String> set = new HashSet<>();

        for (JPacket packet:packets){
            if (packet.hasHeader(http)){
                String temp =http.fieldValue((Http.Request.Referer));
                String urlVisited = String.valueOf(temp);

                if (!urlVisited.equals("null")){ // getting rid of null values
                   // System.out.println(jap);
                    set.add(urlVisited);
                }
            }
        }
        if (x==0) { // returns a filtered set
            return filteredSet(set);
        }
        return set;
    }
    private HashSet<String> filteredSet(HashSet<String> set){
        // filters for only websites
        // websites are defined as links that have "/" at the end.
        HashSet<String> hashSet = new HashSet<>();
        for (String temp : set) {
            if (temp.endsWith("/")) {
                hashSet.add(temp);
            }
        }
        return hashSet;
    }
}