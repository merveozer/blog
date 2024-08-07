Follow the [Trello Board](https://trello.com/b/iAlaRmK6/blog-application).

# Blog Application

## Overview

This project is a simple backend API for managing blog posts. It allows users to create, update, and manage blog posts with titles, text, and tags. The API is built using Spring Boot and PostgreSQL database.

## Features

- **Create Blog Posts**: Users can create blog posts with a title and text.
- **List Blog Posts**: Retrieve a simplified list of all blog posts with titles and short summaries.
- **Update Blog Posts**: Update the title and text of existing blog posts.
- **Manage Tags**: Add or remove tags from blog posts.
- **Filter by Tag**: Retrieve blog posts associated with a specific tag.
- **API Documentation**: Fully documented API using Swagger.
- **JWT Authorization**: Secured endpoints with JWT-based authentication.

## Requirements

- **Java**: JDK 17
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Testing**: JUnit 5 for unit tests, TestContainers for integration tests
- **Documentation**: Swagger for API documentation
- **Docker**: Dockerize the application
- **Caching**: Implement caching for improved performance

## Setup Guide

1. **Clone the Repository**
   ```bash
   git clone https://github.com/merveozer/blog.git
   cd blog

