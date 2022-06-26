package lab4;

import java.util.List;

public abstract class SpecialNumber {
    public abstract SpecialNumber add(SpecialNumber num) throws Lab4Exception;
    public abstract SpecialNumber divideByInt(int num) throws Lab4Exception;

    /**
     * Compute the average of elements of List.
     * @param nums              The list of SpecialNumber Objects
     * @return                  The SpecialNumber Object with average value
     *                          of the list of objects
     * @throws Lab4Exception    Show error message "List cannot be empty" if
     *                          NUMS is null or empty.
     */
    static public SpecialNumber computeAverage(List<SpecialNumber> nums) throws Lab4Exception {
        if (nums == null || nums.isEmpty())
            throw new Lab4Exception("List cannot be empty");
        // List has elements
        int size = nums.size();
        SpecialNumber res = nums.get(0);
        // Get sum
        for (int i = 1; i < size; i++)
            res = res.add(nums.get(i));
        // Get average
        return res.divideByInt(size);
    }
}
