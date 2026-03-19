cmake_minimum_required(VERSION 3.16)

# Project name and language
project(MyProjectName VERSION 1.0 LANGUAGES CXX)

# Set C++ standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Optional: enable warnings (GCC/Clang)
if (CMAKE_CXX_COMPILER_ID MATCHES "GNU|Clang")
    add_compile_options(-Wall -Wextra -Wpedantic)
endif()

# Source files
set(SOURCES
        main.cpp
)

# Include directories
include_directories(include)

# Create executable
add_executable(${PROJECT_NAME} ${SOURCES})