cmake_minimum_required(VERSION 3.23)
project(klogger)

set(CMAKE_CXX_STANDARD 14)
set(CMAKE_EXE_LINKER_FLAGS "-static")

add_executable(klogger main.cpp)
