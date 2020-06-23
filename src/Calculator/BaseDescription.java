package Calculator;

/**
 * This class holds a (rank, percent damage) pair for a base.
 *
 */

public class BaseDescription {

    /**
     * Rank, unique identifier given to a base in the form of an positive non-zero integer
     * ranging from 1-50 as 50 is the maximum number of participants allowed in the game
     */
    private int rank;

    /**
     * PercentDamage, integer value for damage inflicted on a base. Values are integers ranging from 0-100
     */
    private int percentDamage;


    /**
     * Initializes as empty constructor
     */
    public BaseDescription(){}

    /**
     *
     * @param percentDamage percentDamage to set
     */
    public void setPercentDamage(int percentDamage){
        this.percentDamage = percentDamage;
    }

    /**
     *
     * @param rank rank to set
     */
    public void setRank(int rank){
        this.rank = rank;
    }

    /**
     *
     * @return rank of this base (its identifier)
     */
    public int getRank(){
        return rank;
    }

    /**
     *
     * @return current percentage of damage that was inflicted on this base
     */
    public int getPercentDamage(){
        return percentDamage;
    }




}
