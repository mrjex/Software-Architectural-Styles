# Fundamentals of Software Architecture

![C++](https://img.shields.io/badge/C++-00599C?style=flat-square&logo=c%2B%2B&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black)
![Node.js](https://img.shields.io/badge/Node.js-339933?style=flat-square&logo=nodedotjs&logoColor=white)
![Vue.js](https://img.shields.io/badge/Vue.js-4FC08D?style=flat-square&logo=vuedotjs&logoColor=white)
![Express.js](https://img.shields.io/badge/Express.js-000000?style=flat-square&logo=express&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)

> Developed by [Mohamad Khalil](https://github.com/Chef03), [Joel Mattsson](https://github.com/mrjex), and Jackson Niyomugabo during August - October 2023

## Table of Contents

- [Fundamentals of Software Architecture](#fundamentals-of-software-architecture)
  - [Table of Contents](#table-of-contents)
  - [Overview](#overview)
  - [System Descriptions](#system-descriptions)
  - [Architectures](#architectures)
    - [Pipe And Filter](#pipe-and-filter)
    - [Web Services](#web-services)
    - [Microservices](#microservices)
  - [Demos](#demos)

## Overview

This project explores three distinct software architectural styles through practical implementation. We learned about architecture with respect to pros and cons coupled with quality attributes such as **Performance**, **Availability**, and **Reliability** and studied different architectural approaches.

## System Descriptions

[Module 1](pipe-and-filter/README.md) is an image manipulation program written in C++ that utilizes a variety of filters to modify provided images. This module demonstrates the **Pipe-And-Filter** architectural style. Note that extensive knowledge of C++ is not expected to complete the exercises.

[Module 2](web-services/README.md) is Brimula, a staff management web platform designed specifically for examiners and lecturers, with front-end and back-end modules. This module implements the **Web-Services** architectural style.

[Module 3](microservices/README.md) is an application storing customer data as a collection of orders, written in Java. It consists of a command-line based user interface and MySQL database back-end. This module is designed around the **Microservices architectural style**, utilizing Java's Remote Method Invocation (RMI).

## Architectures

### Pipe And Filter

The Pipe and Filter architecture processes data through a sequence of independent components (filters) connected by pipes. Each filter performs a specific transformation on the input data and passes the result to the next filter.

![pipe-and-filter](readme-material/pipe-filter.PNG)

### Web Services

The Web Services architecture uses HTTP-based communication protocols to enable client-server interaction. The frontend and backend are separated, with REST APIs facilitating data exchange between components.

![web-services](readme-material/web-services.PNG)

### Microservices

The Microservices architecture decomposes the application into small, independently deployable services. Each service focuses on a specific business function and communicates with others through lightweight protocols.

![microservices](readme-material/microservices.PNG)

## Demos

**Pipe And Filter (C++):** ![pipe-and-filter-video](demos/pipe-and-filter.mp4)

**Web Services (Javascript):** ![webservices-video](demos/webservices.mp4)

**Microservices (Java):** ![microservices-video](demos/microservices.mp4)