/* Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms. */

using System.Collections.Generic;

namespace Project_Euler.Problem2 {
    class Problem2
    {
        // Stop finding numbers in the Fibonacci sequence at 4.000.000
        private const uint Max = 4000000;

        /// <summary>
        /// Finds the sum of even numbers in the fibonacci sequence up to a given upper limit
        /// </summary>
        /// <param name="maxNumber">The upper limit of numerical values in the fibonacci sequence to sum</param>
        /// <returns></returns>
        public static ulong FindFibonacciNumbers(int maxNumber)
        {
            // Create the starting list of Fibonacci numbers (1 & 2)
            List<uint> numbers = new List<uint> {
                1,
                2
            };

            // Add the rest of the numbers to the list
            FibonacciList(ref numbers);

            // Find the sum of all even numbers
            ulong sum = 0;
            foreach (uint number in numbers)
            {
                // If the number in the sequence is even
                if (number % 2 == 0)
                {
                    // Add it to the sum
                    sum += number;
                }
            }

            return sum;
        }

        /// <summary>
        /// Adds the sum of the last two numbers from a list, to the list, until a max upper limit is reached
        /// </summary>
        /// <param name="numbers">The list of numbers representing the fibonacci sequence</param>
        public static void FibonacciList(ref List<uint> numbers)
        {
            uint lastTwoNumbers = numbers[numbers.Count - 1] + numbers[numbers.Count - 2];

            while (lastTwoNumbers < Max)
            {
                numbers.Add(lastTwoNumbers);
                lastTwoNumbers = numbers[numbers.Count - 1] + numbers[numbers.Count - 2];
            }
        }
    }
}