#ifndef __ITERATIV_SELECTION_CPP
#define __ITERATIV_SELECTION_CPP
#include <iostream>
using namespace std;
typedef char itemType;

void iterativeSelectionSort(itemType *arr);

void iterativeSelectionSort(itemType *arr) {
	itemType temp;

	for (int j = 0; j < strlen(arr); j++)
	{
		int minst = 0 + j;
		for (int i = 0 + j; i < strlen(arr); i++)
		{
			if (arr[i] < arr[minst]) minst = i;
		}
		temp = arr[j];
		arr[j] = arr[minst];
		arr[minst] = temp;
	}
}
#endif