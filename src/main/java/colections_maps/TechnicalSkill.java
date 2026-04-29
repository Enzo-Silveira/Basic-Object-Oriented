package colections_maps;

import java.util.Objects;

public final class TechnicalSkill implements Comparable<TechnicalSkill>{
    private final String skillName;
    private final int proficiencyLevel;

    public TechnicalSkill(String skillName, int proficiencyLevel) {
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
    }

    public TechnicalSkill(String skillName) {
        this.skillName = skillName;
        this.proficiencyLevel = 0;
    }

    @Override
    public String toString() {
        return "TechnicalSkill{" +
                "skillName='" + skillName + '\'' +
                ", proficiencyLevel=" + proficiencyLevel +
                '}';
    }

    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnicalSkill that = (TechnicalSkill) o;
        return Objects.equals(skillName, that.skillName);
    }
    public int hashCode() { return Objects.hash(skillName); }
    public int compareTo(TechnicalSkill out) { return skillName.compareTo(out.skillName) ; }

    public String getSkillName() {
        return skillName;
    }

    public int getProficiencyLevel() {
        return proficiencyLevel;
    }
}