public interface Terrestrial {
    int getLegNum();

    void setLegNum(int legNum) throws Cat.OutOfObjectiveConditionException, Duck.OutOfObjectiveConditionException;
}
