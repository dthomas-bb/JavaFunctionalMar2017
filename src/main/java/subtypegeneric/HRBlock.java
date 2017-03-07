package subtypegeneric;

import java.util.ArrayList;
import java.util.List;

public class HRBlock {
    public static void computeTaxes(Taxable t) {
    }
    
    public static void bulkComputeTaxes(List<? extends Taxable> lt) {
        for (Taxable t : lt) {
            computeTaxes(t);
//            lt.add(t);  // not allowed! Don't know that Taxable is assignment compatible with ?
        }
    }
    
    public static void bulkAddIndividualClients(List<? super Individual> lt) {
        Individual t = null;
        lt.add(t);
    }

    public static void main(String[] args) {
        Individual i = null;
        computeTaxes(i);
        Corporation c = null;
        computeTaxes(c);
        
        List<Taxable> lt = new ArrayList<>();
        lt.add(i);
        lt.add(c);
        bulkComputeTaxes(lt);
        
        List<Individual> li = new ArrayList<>();
        bulkComputeTaxes(li);
        
        bulkAddIndividualClients(lt);
        bulkAddIndividualClients(li);
        
    }
}
