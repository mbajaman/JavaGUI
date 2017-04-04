package app;

import org.jnetpcap.Pcap;
import java.io.File;
import java.util.ArrayList;


public class model {
    TCP tcp;
    Pcap pcap;
    File fileM;
    ArrayList<String> list;


    public model() {
        tcp = new TCP();
    }

    public void TcpSetup(File file) {
        final StringBuilder errbuf = new StringBuilder();
        this.pcap = Pcap.openOffline(file.getAbsolutePath(), errbuf);
    }

    public void print() {
        System.out.println(list);
    }
}
