#include <opencv2/imgproc/imgproc.hpp>

// FILTER 1: flip image along horizontal axis
void filter1(cv::Mat img)
{
    int width = img.cols;
    int height = img.rows;
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width / 2; j++)
        {
            cv::Vec3b pixel = img.at<cv::Vec3b>(i, j);
            img.at<cv::Vec3b>(i, j) = img.at<cv::Vec3b>(i, width - 1 - j);
            img.at<cv::Vec3b>(i, width - 1 - j) = pixel;
        }
    }
}