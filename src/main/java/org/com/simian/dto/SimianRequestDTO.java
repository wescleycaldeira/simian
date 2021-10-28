package org.com.simian.dto;

import java.io.Serializable;
import java.util.Arrays;

public class SimianRequestDTO implements Serializable {

    public SimianRequestDTO(String[] dna) {
        this.dna = dna;
    }

    public SimianRequestDTO() {
    }

    private String [] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimianRequestDTO that = (SimianRequestDTO) o;
        return Arrays.equals(dna, that.dna);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(dna);
    }

    @Override
    public String toString() {
        return "SimianRequestDTO{" +
                "dna=" + Arrays.toString(dna) +
                '}';
    }
}
