package DataStructure.Polynominal;

class Polynominal
{
    private static final int INIT_SIZE = 3;
    private Term[] termArray;
    private int terms;

    Polynominal() {
        this(INIT_SIZE);
    }

    Polynominal(int size)
    {
        termArray = new Term[size];
        terms = 0;
    }

    int getTerms()
    {
        return terms;
    }

    private void resize(int newSize)
    {
        Term [] tmp = new Term[newSize];
        for(int i=0; i<terms; i++)
            tmp[i] = termArray[i];
        termArray = tmp;
    }

    void addTerm(Term term)
    {
        for(int i=0; i<terms; i++)
        {
            int diff = termArray[i].compareExp(term);
            // 새로 들어오는 항의 지수가
            if(diff == 1) // 크면 작은 지수를 가진 항들 뒤로 밀기
            {
                insert(term, i);
                return;
            }
            else if(diff == 0) // 같으면 계수 더해줌
             {
                 double newCoef = termArray[i].getCoef() + term.getCoef();
                 if(newCoef != 0)
                     termArray[i].setCoef(newCoef);
                 else // 더한 결과가 0인 경우
                     delete(i);
                 return;
             }
             // 작으면 배열의 다음 항 확인
        }
        // termArray의 마지막 항까지 다 본 경우. 즉, 새로 들어오려는 항의 지수가 가장 작은 경우
        if(terms == termArray.length)
            resize(terms*2);
        termArray[terms] = term;
        terms++;
    }

    private void insert(Term t, int index)
    {
        if(terms == termArray.length)
            resize(terms*2);

        for(int i=terms-1; i>=index; i--)
            termArray[i+1] = termArray[i];
        termArray[index] = t;
        terms++;
    }

    private void delete(int index)
    {
        for(int i=index; i<terms-1; i++)
            termArray[i] = termArray[i+1];
        termArray[terms-1] = null;
        terms--;

        if(terms > 0 && terms == termArray.length/4)
            resize(termArray.length/2);
    }

    Polynominal addPoly(Polynominal poly)
    {
        Polynominal res = new Polynominal();

        // poly1의 termArray의 값들을 res에 저장
        for(int i=0; i<terms; i++)
            res.addTerm(new Term(termArray[i].getCoef(), termArray[i].getExp()));

        // poly2의 termArray의 값들을 res에 저장
        for(int i=0; i<poly.terms; i++)
            res.addTerm(new Term(poly.termArray[i].getCoef(), poly.termArray[i].getExp()));

        return res;
    }

    Polynominal multiplyPoly(Polynominal poly)
    {
        double coef;
        int exp;

        Polynominal res = new Polynominal();
        Polynominal tmp = new Polynominal();

        for(int i=0; i<terms; i++)
        {
            for(int j=0; j<poly.terms; j++)
            {
                coef = this.termArray[i].getCoef() * poly.termArray[j].getCoef();
                exp = this.termArray[i].getExp() + poly.termArray[j].getExp();
                res.addTerm(new Term(coef, exp));
            }
        }
        return res;
    }

    public String toString()
    {
        if(terms == 0)
            return "0";

        String res = "";

        for(int i=0; i<terms; i++)
        {
            if(termArray[i].getCoef() > 0)
            {
                if(i!=0)
                    res += " + " + termArray[i];
                else
                    res += termArray[i];
                continue;
            }
            // 계수가 음수인 경우
            res += " - " + termArray[i];
        }
        return res;
    }
}
