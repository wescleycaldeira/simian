package org.com.simian.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@QuarkusTest
public class SimianServiceTest {

    @Inject
    SimianService simianService;

    @Test
    public void testSimianHorizontal() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateHori(listDna);

        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateInput() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};

        Assertions.assertDoesNotThrow(() -> {simianService.validateDnaInput(dna);});
    }

    @Test
    public void testValidateInputException() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGH", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};

        Assertions.assertThrows(Exception.class, () -> {simianService.validateDnaInput(dna);});
    }

    @Test
    public void testSimianNotHorizontal() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCATA", "TCACTG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateHori(listDna);

        Assertions.assertFalse(result);
    }


    @Test
    public void testSimianVertical() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateVerti(listDna);

        Assertions.assertTrue(result);
    }


    @Test
    public void testSimianNotVertical() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGAG", "CCCCTA", "TCACTG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateVerti(listDna);

        Assertions.assertFalse(result);
    }


    @Test
    public void testSimianDiagonal() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "ATAGAG", "CCTCTA", "TCATCG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateDiag(listDna);

        Assertions.assertTrue(result);
    }


    @Test
    public void testSimianNotDiagonal() throws Exception {
        String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGAG", "CCCCTA", "TCACTG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateDiag(listDna);

        Assertions.assertFalse(result);
    }


    @Test
    public void testSimianDiagonalInv() throws Exception {
        String [] dna = {"CTGAGA", "CTAGGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateDiagInv(listDna);

        Assertions.assertTrue(result);
    }


    @Test
    public void testSimianNotDiagonalInv() throws Exception {
        String [] dna = {"CTGAGA", "CTTAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        List<String> listDna = Arrays.asList(dna);

        Boolean result = simianService.validateDiagInv(listDna);

        Assertions.assertFalse(result);
    }


    @Test
    public void testSimianIsSimian() throws Exception {
        String [] dna = {"CTGACA", "CTAGGC", "TATTGT", "AGAGGT", "CCACTA", "TCACTA"};

        Boolean result = simianService.isSimian(dna);

        Assertions.assertTrue(result);
    }

}
