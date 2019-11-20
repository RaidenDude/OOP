// KnowIT Kodekalender dag 1
/* Vi definerer Vekksort (O(n)) til � v�re den line�re sorteringsalgoritmen som:

Traverserer en liste fra f�rste element.
Eliminerer hvert element som er mindre enn det forrige.
Inndata er en tekstfil med ett positivt heltall per linje.

Oppgaven er � finne summen til tallene i en liste sortert ved "hjelp" av Vekksort.

Eksempel input:
5
4
3
6
7
5
2
7
5
1
1
10
Eksempel output: 35 (fordi 5 + 6 + 7 + 7 + 10 = 35) */
#include <iostream>
using namespace std;

int main() {
	struct Node {
		int n;
		Node* next;
		Node(int nr) { n = nr; }
	};

	Node* head = new Node(0);
	Node* current = head;

	int counter = 0;
	const int MAXLEN = 20;
	char tempn[MAXLEN];
	cin.getline(tempn, MAXLEN);

	while (strlen(tempn)) {
		if (atoi(tempn) >= current->n) {
			current->next = new Node(atoi(tempn));
			current = current->next;
			counter += atoi(tempn);
		}
		cin.getline(tempn, MAXLEN);
	}

	cout << counter;
	return 0;
}