# Fundamentals of Software Architecture


- [Mohamad Khalil](https://github.com/Chef03), [Joel Mattsson](https://github.com/mrjex) and Jackson Niyomugabo

- Course: `August - October 2023`
 
  We learned about architecture with respect to pros and cons coupled with quality attributes such as **Performance**, **Availability** and **Reliability** and studied different architectural approaches. The high-level architecture and the technical management of data in [Distributed Systems](https://github.com/Dentanoid) are directly attributable to the insights we gained in this course. It's also worth noting that many of the concepts covered in this course is related to [Software Design Principles](https://github.com/mrjex/Software-Design-Patterns)


## Overview


A4 consists of three separate types of systems. One system is constructed in a Pipe-And-Filter style architecture (Image Manipulation Filters), the second in a Web-Services style, and the other made in the form of Microservices architectural style.  

## System Descriptions  
[Module 1](pipe-and-filter/README.md) is an image manipulation program written in C++, that is to be added with a variety of filters, that modify the image(s) provided, each with their self-defined purpose. Note that **extensive knowledge of C++ is not expected**, in order to complete the exercises that are part of this module, covering the **Pipe-And-Filter** architectural style.

[Module 2](web-services/README.md) is Brimula, a staff management web platform designed specifically for examiners and lecturers, with front-end and back-end modules. This module is to be designed, applying the **web-services** style of architecture. 

[Module 3](microservices/README.md) is an application storing customer data as a collection of orders, written in Java. It consists of a command-line based user interface, and MySQL database back-end. This module is designed around the **microservices architectural style**, made possible using Java's Remote Method Invocation (RMI).

In the course of the assignment you will be asked to modify the systems by adding/improving features, analyze which system better supported the required modifications and analyze the relative tradeoffs between the different architectures. Please read the steps in each of the modules' README files for specific installation and setup procedures.