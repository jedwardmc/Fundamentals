#include <cstdio>
#include <vector>
#include <iostream>


int main() {
    
    std::vector<int> sequence;
    
    // initial values
    int initialPopulation = 50000000;
    int quantityOfYears = 25;
    double growthRate = 1.03;
    
    std::cout << "Initial population >> " << initialPopulation << std::endl;
    std::cout << "Quantity of years >> " << quantityOfYears << std::endl;
    std::cout << "Growth rate >> " << growthRate << std::endl;
    
    // this captures the population growth after a certain period of time
    for (int ii=0; ii < quantityOfYears; ++ii) {
        initialPopulation = initialPopulation * growthRate;
        sequence.push_back(initialPopulation);
        std::cout << "Pop(" << ii + 1 << ") = " << sequence[ii] << std::endl;
    }
}
