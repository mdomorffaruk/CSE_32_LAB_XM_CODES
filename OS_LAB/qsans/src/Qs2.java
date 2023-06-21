import java.util.*;
public class Qs2 {
        static private int numberOfProcess = 5;
        static private int numberOfResources = 3;
        static void calculateNeed(int need[][], int maximumInstance[][],int allocatedInstance[][])
        {
            for (int i = 0 ; i < numberOfProcess ; i++)
                for (int j = 0 ; j < numberOfResources ; j++)
                    need[i][j] = maximumInstance[i][j] - allocatedInstance[i][j];
        }
        
        static boolean isSafe(int processes[], int availableInstance[], int maximumInstance[][], int allocatedInstance[][])
        {
            int [][]need = new int[numberOfProcess][numberOfResources];

            // Function to calculate need matrix
            calculateNeed(need, maximumInstance, allocatedInstance);

            // Mark all processes as finish
            boolean []finish = new boolean[numberOfProcess];

            // To store safe sequence
            int []safeSeq = new int[numberOfProcess];

            // Make a copy of available resources
            int []work = new int[numberOfResources];
            for (int i = 0; i < numberOfResources ; i++)
                work[i] = availableInstance[i];

            // While all processes are not finished
            // or system is not in safe state.
            int count = 0;
            while (count < numberOfProcess)
            {
                // Find a process which is not finish and
                // whose needs can be satisfied with current
                // work[] resources.
                boolean found = false;
                for (int p = 0; p < numberOfProcess; p++)
                {
                    // First check if a process is finished,
                    // if no, go for next condition
                    if (finish[p] == false)
                    {
                        // Check if for all resources of
                        // current numberOfProcess need is less
                        // than work
                        int j;
                        for (j = 0; j < numberOfResources; j++)
                            if (need[p][j] > work[j])
                                break;

                        // If all needs of p were satisfied.
                        if (j == numberOfResources)
                        {
                            // Add the allocated resources of
                            // current numberOfProcess to the available/work
                            // resources i.e.free the resources
                            for (int k = 0 ; k < numberOfResources ; k++)
                                work[k] += allocatedInstance[p][k];

                            // Add this process to safe sequence.
                            safeSeq[count++] = p;

                            // Mark this p as finished
                            finish[p] = true;

                            found = true;
                        }
                    }
                }

                // If we could not find a next process in safe
                // sequence.
                if (found == false)
                {
                    System.out.print("System is not in safe state");
                    return false;
                }
            }

            // If system is in safe state then
            // safe sequence will be as below
            System.out.print("System is in safe state.\nSafe"
                    +" sequence is: ");
            for (int i = 0; i < numberOfProcess-1 ; i++)
                System.out.print("P"+safeSeq[i] + " --> ");
            System.out.println("P"+safeSeq[numberOfProcess-1] );
            return true;
        }

        // Driver code
        public static void main(String[] args)
        {
            int processes[] = {0, 1, 2, 3, 4};

            // Available instances of resources
            int availableInstance[] = {3, 3, 2};

            // Maximum numberOfResources that can be allocated
            // to processes
            int maximumInstance[][] = {
                    {8, 5, 3},
                    {3, 2, 2},
                    {9, 0, 2},
                    {2, 2, 2},
                    {4, 3, 3}
            };

            // Resources allocated to processes
            int allocatedInstance[][] = {
                    {0, 1, 0},
                    {2, 0, 0},
                    {3, 0, 2},
                    {2, 1, 1},
                    {0, 0, 2}
            };

            // Check system is in safe state or not
            isSafe(processes, availableInstance, maximumInstance, allocatedInstance);
        }
    }



