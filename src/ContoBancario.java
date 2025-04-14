import java.util.ArrayList;

/**
 * Classe che rappresenta un conto bancario.
 */
public class ContoBancario {
    /**
     * L'IBAN del conto bancario.
     */
    protected String iban;
    /**
     * Il saldo del conto bancario.
     */
    protected double saldo;
    /**
     * La lista dei movimenti del conto bancario.
     */
    protected ArrayList<String> movimenti;

    /**
     * Costruttore che inizializza il conto bancario con un IBAN e un saldo.
     * @param iban il numero del conto bancario
     * @param saldo il saldo iniziale del conto bancario
     */
    public ContoBancario(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    /**
     * Deposita una somma di denaro sul conto bancario, incrementando il saldo.
     * @param importo la somma di denaro da depositare
     * @throws IllegalArgumentException se l'importo e' negativo
     */
    public void deposita(double importo){
        if (importo < 0 ) {
            throw new IllegalArgumentException("importo negativo");
        } else {
            this.saldo = this.saldo + importo;
        }
    }

    /**
     * Restituisce il numero del conto bancario.
     * @return il numero del conto bancario
     */
    public String getIban() {
        return iban;
    }

    /**
     * Restituisce il saldo del conto bancario.
     * @return il saldo del conto bancario
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Preleva una somma di denaro dal conto bancario, decrementando il saldo.
     * @param importo la somma di denaro da prelevare
     * @throws IllegalArgumentException se l'importo e' negativo o supera il saldo
     */
    public void preleva(double importo){
        if (importo < 0 && importo > this.saldo) {
            throw new IllegalArgumentException("importo negatico o supera il saldo");
        } else {
            this.saldo = this.saldo - importo;
        }
    }

    /**
     * Restituisce una rappresentazione stringa del conto bancario.
     * Include l'IBAN e il saldo. La rappresentazione stringa e' formattata per essere facile da leggere e comprendere. Ecco un esempio di come potrebbe apparire la rappresentazione stringa:  <br>
     * ```  <br>
     * Conto Bancario:  <br>
     * IBAN: IT12X0542811101000000123  <br>
     * Saldo: 1000.0 EUR  <br>
     * ```  
     * @Overrides toString in class Object
     * @return una rappresentazione stringa del conto bancario, inclusivo di IBAN e saldo
     */
    @Override
    public String toString() {
        return "ContoBancario [iban=" + iban + ", saldo=" + saldo + "]";
    }

    /**
     * Restituisce la lista dei movimenti del conto bancario.
     * @return la lista dei movimenti del conto bancario
     */
    public ArrayList<String> getMovimenti() {
        return movimenti;
    }

    /**
     * Restituisce gli ultimi n movimenti del conto bancario.
     * @param n il numero di movimenti da restituire
     * @return gli ultimi n movimenti del conto bancario
     */
    public ArrayList<String> getUltimiMovimenti(int n){
        ArrayList<String> x = new ArrayList();
        if (movimenti.size() >= n) {
             for (int i = movimenti.size() - n; i < movimenti.size(); i++) {
                x.add(movimenti.get(i));
             }
        } else {
            return movimenti;
        }
        
        return x;
    }
    
    
    

}