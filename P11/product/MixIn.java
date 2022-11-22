package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn {
    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }
    public MixIn(BufferedReader in) throws IOException {
        amount = MixInAmount.valueOf(in.readLine());
        flavor = new MixInFlavor(in);
    }
    
    public void save(BufferedWriter out) throws IOException {
        out.write(amount.toString() + '\n');
        flavor.save(out);
    }
    
    public int price() {
    	return flavor.price();
    }
    
    @Override
    public String toString() {
//        return flavor.toString() + ((amount != MixInAmount.Normal)
        return flavor.toString() + (!amount.equals(MixInAmount.Normal)
                                 ? " (" + amount + ")"
                                 : "");
    }
    
    private MixInFlavor flavor;
    private MixInAmount amount;
}
