#include <opencv2/imgproc/imgproc.hpp>

// FILTER 2: flip image along vertical axis
void filter2(cv::Mat img)
{
    int width = img.cols;
    int height = img.rows;
    for (int i = 0; i < height / 2; i++)
    {
        for (int j = 0; j < width; j++)
        {
            cv::Vec3b pixel = img.at<cv::Vec3b>(i, j);
            img.at<cv::Vec3b>(i, j) = img.at<cv::Vec3b>(height - 1 - i, j);
            img.at<cv::Vec3b>(height - 1 - i, j) = pixel;
        }
    }
}