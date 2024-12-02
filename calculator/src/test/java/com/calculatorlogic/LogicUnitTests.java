package com.calculatorlogic;

import com.calculator.models.XMBInput;
import com.calculator.models.ZScoreInput;
import com.jayway.jsonpath.internal.function.numeric.StandardDeviation;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicUnitTests {

    //-------------------------------------------------------------------
    //INPUT VALIDATION UNIT TESTS FOR SAMPLE STANDARD DEVIATION
    @Test
    void IsDataValidForSampleStandardDeviation_AcceptsValidString_ReturnsListOfDoubles()
    {
        String input = "\"1\\n2\\n3\\n4\"";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForSampleStandardDeviation(input);
        List<Double> referenceList = new ArrayList<Double>();
        referenceList.add(1.0);
        referenceList.add(2.0);
        referenceList.add(3.0);
        referenceList.add(4.0);
        assertEquals(list.get(0), referenceList.get(0));
        assertEquals(list.get(1), referenceList.get(1));
        assertEquals(list.get(2), referenceList.get(2));
        assertEquals(list.get(3), referenceList.get(3));
    }

    @Test
    void IsDataValidForSampleStandardDeviation_AcceptsNull_ReturnsNull()
    {
        String input = null;
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForSampleStandardDeviation(input);

        assertNull(list);
    }

    @Test
    void IsDataValidForSampleStandardDeviation_AcceptsLessThan2Args_ReturnsNull()
    {
        String input = "\"1\"";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForSampleStandardDeviation(input);

        assertNull(list);

        input = "";
        list = ds.IsDataValidForSampleStandardDeviation(input);

        assertNull(list);
    }

    @Test
    void IsDataValidForSampleStandardDeviation_AcceptsNonDecimalInput_ReturnsNull()
    {
        String input = "\"1\n2\nA\nblah\"";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForSampleStandardDeviation(input);

        assertNull(list);
    }








    //-----------------------------------------------------------------------
    //INPUT VALIDATION UNIT TESTS FOR POPULATION STANDARD DEVIATION
    @Test
    void IsDataValidForPopulationStandardDeviation_AcceptsValidString_ReturnsListOfDoubles()
    {
        String input = "\"1\\n2\\n3\\n4\"";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForPopulationStandardDeviation(input);
        List<Double> referenceList = new ArrayList<Double>();
        referenceList.add(1.0);
        referenceList.add(2.0);
        referenceList.add(3.0);
        referenceList.add(4.0);
        assertEquals(list.get(0), referenceList.get(0));
        assertEquals(list.get(1), referenceList.get(1));
        assertEquals(list.get(2), referenceList.get(2));
        assertEquals(list.get(3), referenceList.get(3));
    }

    @Test
    void IsDataValidForPopulationStandardDeviation_AcceptsNull_ReturnsNull()
    {
        String input = null;
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForPopulationStandardDeviation(input);

        assertNull(list);
    }

    @Test
    void IsDataValidForPopulationStandardDeviation_AcceptsNoArgs_ReturnsNull()
    {
        String input = "";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForPopulationStandardDeviation(input);

        assertNull(list);
    }

    @Test
    void IsDataValidForPopulationStandardDeviation_AcceptsNonDecimalInput_ReturnsNull()
    {
        String input = "\"1\n2\nA\nblah\"";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForPopulationStandardDeviation(input);

        assertNull(list);
    }












    //--------------------------------------------------------------------
    //INPUT VALIDATION UNIT TESTS FOR MEAN
    @Test
    void IsDataValidForMean_AcceptsValidString_ReturnsListOfDoubles()
    {
        String input = "\"1\\n2\\n3\\n4\"";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForMean(input);
        List<Double> referenceList = new ArrayList<Double>();
        referenceList.add(1.0);
        referenceList.add(2.0);
        referenceList.add(3.0);
        referenceList.add(4.0);
        assertEquals(list.get(0), referenceList.get(0));
        assertEquals(list.get(1), referenceList.get(1));
        assertEquals(list.get(2), referenceList.get(2));
        assertEquals(list.get(3), referenceList.get(3));
    }

    @Test
    void IsDataValidForMean_AcceptsNull_ReturnsNull()
    {
        String input = null;
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForMean(input);

        assertNull(list);
    }

    @Test
    void IsDataValidForMean_AcceptsNoArgs_ReturnsNull()
    {
        String input = "";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForMean(input);

        assertNull(list);
    }

    @Test
    void IsDataValidForMean_AcceptsNonDecimalInput_ReturnsNull()
    {
        String input = "\"1\n2\nA\nblah\"";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = ds.IsDataValidForMean(input);

        assertNull(list);
    }







    //------------------------------------------------------
    //INPUT VALIDATION UNIT TESTS FOR Z SCORE
    @Test
    void IsDataValidForZScore_AcceptsValidString_ReturnsZScoreInput()
    {
        String input = "{\"value\":\"11.5\",\"mean\":\"7\",\"stdDev\":\"1.5811388300841898\"}";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ZScoreInput result = ds.IsDataValidForZScore(input);
        ZScoreInput referenceValue = new ZScoreInput();
        referenceValue.value = 11.5;
        referenceValue.mean = 7;
        referenceValue.stdDev = 1.5811388300841898;
        assertEquals(referenceValue, result);
    }

    @Test
    void IsDataValidForZScore_AcceptsInvalids_ReturnsNull()
    {
        String input = "{\"blah\":\"11.5\",\"mean\":\"7\",\"stdDev\":\"1.5811388300841898\"}";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ZScoreInput result = ds.IsDataValidForZScore(input);

        assertNull(result);


        input = "{\"value\":\"blah\",\"mean\":\"7\",\"stdDev\":\"1.5811388300841898\"}";
        ds = new DescriptiveStatistics();
        result = ds.IsDataValidForZScore(input);

        assertNull(result);
    }

    @Test
    void IsDataValidForZScore_AcceptsNull_ReturnsNull()
    {
        String input = null;
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ZScoreInput result = ds.IsDataValidForZScore(input);

        assertNull(result);
    }

    @Test
    void IsDataValidForZScore_AcceptsNoArgs_ReturnsNull()
    {
        String input = "";
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ZScoreInput result = ds.IsDataValidForZScore(input);

        assertNull(result);
    }














    //---------------------------------------------------------
    //CALCULATION FUNCTIONS
    //---------------------------------------------------------

    @Test
    void CalculatesStandardDeviation_ValidList_ReturnsDouble()
    {
        //for sample standard deviation
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = new ArrayList<Double>();
        list.add(9.0);
        list.add(6.0);
        list.add(8.0);
        list.add(5.0);
        list.add(7.0);
        Double result = ds.StandardDeviation(list);
        assertEquals(1.5811388300841898, result);
    }

    @Test
    void CalculatesStandardDeviation_ListOfZeroes_ReturnsDouble()
    {
        //for sample standard deviation
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = new ArrayList<Double>();
        list.add(0.0);
        list.add(0.0);
        list.add(0.0);
        list.add(0.0);
        list.add(0.0);
        Double result = ds.StandardDeviation(list);
        assertEquals(0.0, result);
    }

    @Test
    void CalculatesStandardDeviation_EmptyOrNullList_ReturnsNull()
    {
        //for sample standard deviation
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = new ArrayList<Double>();
        Double result = ds.StandardDeviation(list);
        assertEquals(null, result);

        list = null;
        result = ds.StandardDeviation(list);
        assertEquals(null, result);
    }

    @Test
    void CalculatesPopulationDeviation_ValidList_ReturnsDouble()
    {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = new ArrayList<Double>();
        list.add(9.0);
        list.add(6.0);
        list.add(8.0);
        list.add(5.0);
        list.add(7.0);
        Double result = ds.PopulationStandardDeviation(list);
        assertEquals(1.4142135623730951, result);
    }

    @Test
    void CalculatesPopulationDeviation_ListOfZeroes_ReturnsDouble()
    {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = new ArrayList<Double>();
        list.add(0.0);
        list.add(0.0);
        list.add(0.0);
        list.add(0.0);
        list.add(0.0);
        Double result = ds.PopulationStandardDeviation(list);
        assertEquals(0.0, result);
    }

    @Test
    void CalculatesPopulationDeviation_EmptyOrNullList_ReturnsNull()
    {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = new ArrayList<Double>();
        Double result = ds.PopulationStandardDeviation(list);
        assertEquals(null, result);

        list = null;
        result = ds.PopulationStandardDeviation(list);
        assertEquals(null, result);
    }

    @Test
    void CalculatesPopulationDeviation_ListWith1Sample_ReturnsDouble()
    {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        List<Double> list = new ArrayList<Double>();
        list.add(5.0);
        Double result = ds.PopulationStandardDeviation(list);
        assertEquals(0.0, result);
    }

    @Test
    void Mean_ListOfValidNumbers_ReturnsDouble()
    {
        List<Double> list = new ArrayList<Double>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        DescriptiveStatistics ds = new DescriptiveStatistics();
        assertEquals(2,ds.Mean(list));
    }

    @Test
    void Mean_EmptyList_ReturnsNull()
    {
        List<Double> list = new ArrayList<Double>();
        DescriptiveStatistics ds = new DescriptiveStatistics();
        assertNull(ds.Mean(list));
    }

    @Test
    void Mean_AcceptsNull_ReturnsNull()
    {
        List<Double> list = null;
        DescriptiveStatistics ds = new DescriptiveStatistics();
        assertNull(ds.Mean(list));
    }

    @Test
    void ZScore_ValidListOfParameters_ReturnsDouble()
    {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ZScoreInput referenceValue = new ZScoreInput();
        referenceValue.value = 11.5;
        referenceValue.mean = 7;
        referenceValue.stdDev = 1.5811388300841898;
        double result = ds.ZScore(referenceValue);
        assertEquals(2.846049894151541, result);
    }

    @Test
    void ZScore_NullInput_ReturnsNull()
    {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ZScoreInput referenceValue = null;
        Double result = ds.ZScore(referenceValue);
        assertNull(result);
    }

    @Test
    void ZScore_StdDevIsZero_ReturnsNull()
    {
        DescriptiveStatistics ds = new DescriptiveStatistics();
        ZScoreInput referenceValue = new ZScoreInput();
        referenceValue.value = 11.5;
        referenceValue.mean = 7;
        referenceValue.stdDev = 0.0;
        Double result = ds.ZScore(referenceValue);
        assertNull(result);
    }



















    // ---------------------------------------------------------------------
    // Extraction/Parsing Functions
    // ---------------------------------------------------------------------



    //-----------------------------------------------------------------------
    // INPUT VALIDATION UNIT TESTS FOR LINEAR REGRESSION
    @Test
    void IsDataValidForLinearRegression_StringOfXYPairs_ReturnsList()
    {
        String input =
                "\"1.47,52.21\\n" +
                "\"1.5,53.12\\n" +
                "\"1.52,54.48\\n" +
                "\"1.55,55.84\\n" +
                "\"1.57,57.2\\n" +
                "\"1.6,58.57\\n" +
                "\"1.63,59.93\\n" +
                "\"1.65,61.29\\n" +
                "\"1.68,63.11\\n" +
                "\"1.7,64.47\\n" +
                "\"1.73,66.28\\n" +
                "\"1.75,68.1\\n" +
                "\"1.78,69.92\\n" +
                "\"1.8,72.19\\n" +
                "\"1.83,74.46\"";

        LinearRegression lr = new LinearRegression();
        List<XYPair> result = lr.IsDataValidForLinearRegression(input);
        XYPair pair1 = new XYPair();
        pair1.x = 1.47;
        pair1.y = 52.21;

        XYPair pair14 = new XYPair();
        pair14.x = 1.83;
        pair14.y = 74.46;

        assertEquals(result.get(0).x, pair1.x);
        assertEquals(result.get(0).y, pair1.y);

        assertEquals(result.get(14).x, pair14.x);
        assertEquals(result.get(14).y, pair14.y);
    }

    @Test
    void IsDataValidForLinearRegression_StringWithIncorrectlyFormattedPair_ReturnsList()
    {
        String input =
                "\"1.47,52.21\\n" +
                        "\"1.5,53.12\\n" +
                        "\"1.52,54.48\\n" +
                        "\"1.55,55.84\\n" +
                        "\"1.57,57.2\\n" +
                        "\"1.6\\n" +       //messed up this one
                        "\"1.63,59.93\\n" +
                        "\"1.65,61.29\\n" +
                        "\"1.68,63.11\\n" +
                        "\"1.7,64.47\\n" +
                        "\"1.73,66.28\\n" +
                        "\"1.75,68.1\\n" +
                        "\"1.78,69.92\\n" +
                        "\"1.8,72.19\\n" +
                        "\"1.83,74.46\"";

        LinearRegression lr = new LinearRegression();
        List<XYPair> result = lr.IsDataValidForLinearRegression(input);

        assertNull(result);
    }

    @Test
    void IsDataValidForLinearRegression_StringWithInvalidPair_ReturnsList()
    {
        String input =
                        "\"1.47,52.21\\n" +
                        "\"1.5,53.12\\n" +
                        "\"1.52,54.48\\n" +
                        "\"1.55,55.84\\n" +
                        "\"1.57,57.2\\n" +
                        "\"blah,blah\\n" +       //messed up this one
                        "\"1.63,59.93\\n" +
                        "\"1.65,61.29\\n" +
                        "\"1.68,63.11\\n" +
                        "\"1.7,64.47\\n" +
                        "\"1.73,66.28\\n" +
                        "\"1.75,68.1\\n" +
                        "\"1.78,69.92\\n" +
                        "\"1.8,72.19\\n" +
                        "\"1.83,74.46\"";

        LinearRegression lr = new LinearRegression();
        List<XYPair> result = lr.IsDataValidForLinearRegression(input);

        assertNull(result);
    }

    @Test
    void IsDataValidForLinearRegression_EmptyOrNullString_ReturnsList()
    {
        String input = "";

        LinearRegression lr = new LinearRegression();
        List<XYPair> result = lr.IsDataValidForLinearRegression(input);

        assertNull(result);

        input = null;
        result = lr.IsDataValidForLinearRegression(input);

        assertNull(result);
    }




    //-----------------------------------------------------------------------
    //INPUT VALIDATION UNIT TESTS FOR Y VALUE
    @Test
    void IsDataValidForYValue_AcceptsValidString_ReturnsXMBInput()
    {
        String input = "1,4,1";

        LinearRegression lr = new LinearRegression();
        XMBInput result = lr.IsDataValidForYValue(input);

        assertEquals(1, result.x);
        assertEquals(4, result.m);
        assertEquals(1, result.b);
    }

    @Test
    void IsDataValidForYValue_Not3Values_ReturnsNull()
    {
        String input = "1,4";

        LinearRegression lr = new LinearRegression();
        XMBInput result = lr.IsDataValidForYValue(input);
        assertNull(result);
    }

    @Test
    void IsDataValidForYValue_AcceptsNull_ReturnsNull()
    {
        String input = null;

        LinearRegression lr = new LinearRegression();
        XMBInput result = lr.IsDataValidForYValue(input);
        assertNull(result);
    }

    @Test
    void IsDataValidForYValue_IncorrectlyFormattedString_ReturnsNull()
    {
        String input = "1,blah,2";

        LinearRegression lr = new LinearRegression();
        XMBInput result = lr.IsDataValidForYValue(input);
        assertNull(result);
    }



    //-----------------------------------------------------------------------
    //INPUT VALIDATION UNIT TESTS FOR CALCULATE LINEAR REGRESSION
    @Test
    void CalculateLinearRegression_AcceptsListOfXYPairs_ReturnsString()
    {
        List<XYPair> input = new ArrayList<XYPair>();
        input.add(new XYPair(1.47, 52.21));
        input.add(new XYPair(1.5, 53.12));
        input.add(new XYPair(1.52, 54.48));
        input.add(new XYPair(1.55, 55.84));
        input.add(new XYPair(1.57, 57.2));
        input.add(new XYPair(1.6, 58.57));
        input.add(new XYPair(1.63, 59.93));
        input.add(new XYPair(1.65, 61.29));
        input.add(new XYPair(1.68, 63.11));
        input.add(new XYPair(1.7, 64.47));
        input.add(new XYPair(1.73, 66.28));
        input.add(new XYPair(1.75, 68.1));
        input.add(new XYPair(1.78, 69.92));
        input.add(new XYPair(1.8, 72.19));
        input.add(new XYPair(1.83, 74.46));

        LinearRegression lr = new LinearRegression();
        String result = lr.CalculateLinearRegression(input);

        assertEquals("y = 61.272186542110624x + -39.06195591884392", result);
    }

    @Test
    void CalculateLinearRegression_AcceptsEmptyListOfXYPairs_ReturnsNull()
    {
        List<XYPair> input = new ArrayList<XYPair>();
        LinearRegression lr = new LinearRegression();
        String result = lr.CalculateLinearRegression(input);
        assertNull(result);
    }

    @Test
    void CalculateLinearRegression_AcceptsNullListOfXYPairs_ReturnsNull()
    {
        List<XYPair> input = null;
        LinearRegression lr = new LinearRegression();
        String result = lr.CalculateLinearRegression(input);
        assertNull(result);
    }

    @Test
    void CalculateLinearRegression_AcceptsListOfXYPairsWithAllXValuesTheSame_ReturnsNull()
    {
        List<XYPair> input = new ArrayList<XYPair> ();

        double x = 12.5;
        input.add (new XYPair (x, 14));
        input.add (new XYPair (x, 22.2));
        input.add (new XYPair (x, 33.33));
        input.add (new XYPair (x, 4.7));

        LinearRegression lr = new LinearRegression();
        String result = lr.CalculateLinearRegression(input);

        assertEquals("y = NaNx + NaN", result);
    }

    @Test
    void CalculateLinearRegression_AcceptsListOfXYPairsWithAllYValuesTheSame_ReturnsNull()
    {
        List<XYPair> input = new ArrayList<XYPair> ();

        double y = 12.5;
        input.add (new XYPair (14, y));
        input.add (new XYPair (22.2, y));
        input.add (new XYPair (33.33, y));
        input.add (new XYPair (4.7, y));

        LinearRegression lr = new LinearRegression();
        String result = lr.CalculateLinearRegression(input);

        assertEquals("y = 0.0x + 12.5", result);
    }

    @Test
    void CalculateLinearRegression_AcceptsListOfXYPairsWithAllZeroValues_ReturnsNull()
    {
        List<XYPair> input = new ArrayList<XYPair> ();

        for (int i = 0; i < 6; i++)
        {
            XYPair p = new XYPair (0, 0);
            input.add (p);
        }

        LinearRegression lr = new LinearRegression();
        String result = lr.CalculateLinearRegression(input);

        assertEquals("y = NaNx + NaN", result);
    }







    //-----------------------------------------------------------------------
    //CALCULATE Y VALUE UNIT TESTS
    //Can't execute missing parameters test because of the code structure, but it is handled in the input validation
    //tests performed earlier, instead will check for null
    @Test
    void CalculateYValue_AcceptsValidInput_ReturnsDouble()
    {
        XMBInput input = new XMBInput ();
        input.x = 6;
        input.m = -0.04596;
        input.b = 6.9336;

        LinearRegression lr = new LinearRegression();
        double result = lr.CalculateYValue(input);
        assertEquals(6.65784, result);
    }

    @Test
    void CalculateYValue_AcceptsNull_ReturnsNull()
    {
        XMBInput input = null;

        LinearRegression lr = new LinearRegression();
        Double result = lr.CalculateYValue(input);
        assertNull(result);
    }
}