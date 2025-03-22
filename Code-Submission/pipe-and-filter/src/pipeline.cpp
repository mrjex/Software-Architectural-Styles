// Include the GUI and image processing header files from OpenCV
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <chrono>
#include <ctime>
#include <cstdlib>
#include <iostream>
#include <filesystem>
#include "image_compare.cpp"
#include "filter1.cpp"
#include "filter2.cpp"
#include "filter3.cpp"

int main(int32_t argc, char **argv)
{

    namespace fs = std::filesystem;
    std::string folderPath = "../images/";

    // loop for each image
    for (const auto &entry : fs::directory_iterator(folderPath))
    {
        if (fs::is_regular_file(entry) && entry.path().extension().string() == ".jpg")
        {
            // extract image and load to image object
            std::string path = entry.path().filename().string();
            cv::Mat img = cv::imread(folderPath + "/" + path, cv::IMREAD_COLOR);

            // FILTER 1: flip image along horizontal axis
            filter1(img);
            // FILTER 2: flip image along vertical axis
            filter2(img);
            // FILTER 3: convert image to grey scale
            img = filter3(img);

            // Save the resulting image
            cv::imwrite("../" + path, img);

            // CI code, not relevant for the student
            cv::Mat result = cv::imread("../solution/result_" + path, cv::IMREAD_GRAYSCALE);
            bool equalImages = areMatObjectsEqual(img, result);
            if (!equalImages)
            {
                return 1;
            };
        }
    }
    return 0;
}
