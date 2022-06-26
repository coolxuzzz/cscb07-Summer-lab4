package lab4;

import java.util.List;

public abstract class SpecialNumber {
    public abstract SpecialNumber add(SpecialNumber num) throws Lab4Exception;
    public abstract SpecialNumber divideByInt(int num) throws Lab4Exception;

    /**
     * Compute the average of elements of List.
     * Lab4Exception raises when the List is null or empty.
     *
     * @param nums              the list of SpecialNumber Objects
     * @return                  the SpecialNumber Object with average value
     *                          of the list of objects
     * @throws Lab4Exception    Exceptions raises when the list is null or empty
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
