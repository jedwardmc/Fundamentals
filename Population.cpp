#include <cstdio>
#include <vector>
#include <iostream>
#include <curses.h>
#include <unistd.h>

int main() {
    
    int tmp_population = 0;
    double tmp_growth_rate = 0;
    char key_input;
    
    int counter = 0;
    
    while (true) {
        std::cout << "what is the initial population?" << std::endl;
        std::cin >> tmp_population;
    
        std::cout << "what is the growth rate?" << std::endl;
        std::cin >> tmp_growth_rate;
    
        if (tmp_population == 0 || tmp_growth_rate == 0) {
            std::cout << "ERROR: invalid numbers!!!" << std::endl;
        }
        
        // check the quantity of years for growth
        std::cout << "What is the quantity of years you want to check for growth?" << std::endl;
    
        std::cout << "Now hit return multiple times to see results." << std::endl;
        
        for (int p_inc=0; p_inc < 100000; ++p_inc) {
            
            key_input = std::cin.get();
            
            if (key_input) {
                counter += 1;
            }
            
            while (counter >= 1) {
                if (key_input) {
                    break;
                } else {
                    counter--;
                }
            }
            tmp_population = tmp_population * tmp_growth_rate;
            printf("Year = %d, Population = %0.0d ", counter, tmp_population);
            
        }
    }
    
}
