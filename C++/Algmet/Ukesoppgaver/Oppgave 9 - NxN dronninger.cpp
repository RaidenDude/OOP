/* Lag et program (med en rekursiv funksjon) som fors�ker � plassere N sjakkdronninger p� et
NxN brett. Dvs. to dronninger kan hverken st� p� samme linje (i), kolonne (j) eller diagonal,
ellers "sl�r/tar" de hverandre */

// INCLUDES:
#include <iostream>
using namespace std;


// GLOBALE VARIABLER:
int boardSize, solutions = 0;


// DIV. FUNKSJONER:
void displaySolution(bool** board) {
	cout << "Solution #" << ++solutions << ":\n\n\t";
	for (int i = 0; i < boardSize; i++) {
		for (int j = 0; j < boardSize; j++) {
			cout << (board[j][i] ? "x\t" : "0\t");
		}
		cout << "\n\t";
	}
	cout << '\n';
}


bool rowIsFree(bool** board, int x) {		// Finner om det er andre dronninger p� samme rad (alle y-koordinater for en gitt x-koordinat)
	for (int i = 0; i < boardSize; i++) {
		if (board[x][i]) return false;
	}

	return true;
}


bool columnsAreFree(bool** board, int y) {	// Sjekker om alt nedover en gitt rad er ledig (alle x-koordinater for en gitt y-koordinat)
	for (int i = 0; i < boardSize; i++) {
		if (board[i][y]) return false;
	}

	return true;
}


bool diagonalIsFree(bool** board, int x, int y) {
	int xCopy = x, yCopy = y;

	while (x && y) {								// Trekker fra 1 p� b�de x/y til en/begge = 0 (�verst til venstre)
		x--;
		y--;
	}

	int i;
	x > y ? i = x : i = y;							// Setter i til den st�rste av x/y

	for (i; i < boardSize; i++) {					// Sjekker s� om noen av feltene nordvest->s�r�st har dronninger, + 1 p� skr� s�r�st (+x,+y) til grensen p� brettet er n�dd
		if (board[x++][y++]) return false;
	}

	x = xCopy; y = yCopy;							// Setter x/y til opprinnelige verdier

	while (y && x < boardSize - 1) {				// Trekker fra 1 p� x, og legger til 1 p� y (beveger seg opp mot h�yre) til grensen p� brettet er n�dd
		x++;
		y--;
	}

	do {
		if (board[x--][y++]) return false;			// Sjekker s� om noen av feltene nord�st->s�rvest har dronninger, + 1 p� skr� s�rvest (-x,+y) til grensen p� brettet er n�dd
	} while (x && y < boardSize - 1);

	return true;
}


void placeQueen(bool** board, int N) {
	if (!N) displaySolution(board);							// Har plassert N dronninger, displayer l�sning

	for (int i = (boardSize - N); i < boardSize; i++) {		// Looper gjennom x-koordinatene
		for (int j = 0; j < boardSize; j++) {				// Looper gjennom y-koordinatene for hver x-koordinat
			if (rowIsFree(board, i) && columnsAreFree(board, j) && diagonalIsFree(board, i, j)) {
				board[i][j] = true;							// Plasserer dronningen p� i,j koordinater
				placeQueen(board, N - 1);					// Pr�ver � plassere dronningen i neste rad
				board[i][j] = false;						// M� backtracke, noen dronninger kunne ikke plasseres
			}
		}
	}
}


int main() {
	cout << "Hvor stort brett? (NxN): ";
	cin >> boardSize;

	bool **board = new bool*[boardSize]();
	for (int i = 0; i < boardSize; ++i) {
		board[i] = new bool[boardSize]();
	}

	placeQueen(board, boardSize);
	return 0;
}