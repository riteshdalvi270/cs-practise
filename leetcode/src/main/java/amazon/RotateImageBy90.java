package amazon;

/**
 * Rotate image by 90 degree. Created by ritesh on 7/8/17.
 */
public class RotateImageBy90
{

    public static void main(String args[])
    {

        int[][] image = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] output = rotateImage90Brute(image);

        for (int i = 0; i < output[0].length; i++)
        {
            for (int j = 0; j < output.length; j++)
            {

                System.out.print(output[i][j]);
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();

        rotateWithoutBruteForce(image);

        for (int i = 0; i < image[0].length; i++)
        {
            for (int j = 0; j < image.length; j++)
            {

                System.out.print(image[i][j]);
            }

            System.out.println();
        }
    }

    private static int[][] rotateWithoutBruteForce(int[][] image)
    {

        int column = image.length - 1;
        int row = image[0].length - 1;

        for (int i = 0; i <= row - 1; i++)
        {
            for (int j = 0; j < column - 1; j++)
            {

                int temp1 = image[i][j];

                image[i][j] = image[i][column - i];

                int temp2 = image[row - i][j];

                image[row - i][j] = temp1;

                int temp3 = image[row - i][column - i];

                image[row - i][column - i] = temp2;

                image[i][column - i] = temp3;
            }
        }

        return image;
    }

    // not working as expected.
    private static int[][] rotateImage90Brute(int[][] image)
    {

        int[][] output = new int[image[0].length][image.length];

        int m = 0, n = 0;

        for (int i = 0; i < image.length; i++)
        {
            for (int j = image.length - 1; j >= 0; j--)
            {

                output[m][n] = image[i][j];
                m++;
            }
            n++;
            m = 0;
        }

        return output;
    }
}
