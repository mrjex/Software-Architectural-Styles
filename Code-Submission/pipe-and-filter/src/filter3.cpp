#include <opencv2/imgproc/imgproc.hpp>

// FILTER 3: convert image to grey scale
cv::Mat filter3(cv::Mat img)
{
    int width = img.cols;
    int height = img.rows;
    cv::Mat result = cv::Mat(height, width, CV_8UC1);
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            // Formula: 0.299 ∙ Red + 0.587 ∙ Green + 0.114 ∙ Blue
            cv::Vec3b pixel = img.at<cv::Vec3b>(i, j);
            uchar R = pixel[2];
            uchar G = pixel[1];
            uchar B = pixel[0];
            uint8_t avg = (.299 * R) + (.587 * G) + (.114 * B);
            result.at<uint8_t>(i, j) = avg;
        }
    }
    return result;
}