package edu.miracostacollege.cs112.ic16_influencersfx.model;

import java.io.Serializable;
import java.util.Objects;

public class Celebrity extends Influencer implements Serializable, Comparable<Influencer>{
    private String mSponsors;

    public Celebrity(String name, String country, int followers, double worth, String sponsors) {
        super(name, country, followers, worth);
        mSponsors = sponsors;
    }

    public String getSponsors() {
        return mSponsors;
    }

    public void setSponsors(String mSponsors) {
        this.mSponsors = mSponsors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Celebrity celebrity = (Celebrity) o;
        return Objects.equals(mSponsors, celebrity.mSponsors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mSponsors);
    }

    @Override
    public String toString() {
        return "Celebrity [Name=" + mName +
                ", Country=" + mCountry +
                ", Followers=" + mFollowers +
                ", Worth=" + mWorth +
                ", Sponsors=" + mSponsors + ']';
    }

    @Override
    public int compareTo(Influencer o) {
        return 0;
    }
}
