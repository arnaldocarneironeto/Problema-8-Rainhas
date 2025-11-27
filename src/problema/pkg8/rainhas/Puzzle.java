package problema.pkg8.rainhas;

import java.util.ArrayList;
import static problema.pkg8.rainhas.Constants.TABLE_ORDER;

/**
 *
 * @author Arnaldo Carneiro <acsn@a.recife.ifpe.edu.br>
 */
public class Puzzle
{
    private final ArrayList<State> toVisit;

    public Puzzle(State initialState)
    {
        this.toVisit = new ArrayList<>();
        this.toVisit.add(initialState);
    }
    
    public ArrayList<State> findSolution()
    {
        ArrayList<State> solution = new ArrayList<>();
        while(this.toVisit.isEmpty() == false && solution.isEmpty() == true)
        {
            State state = this.toVisit.remove(0);
            if(state.isNotSelfAncestor())
            {
                if(state.numberOfChecks() == 0)
                {
                    //retornar pai do pai do pai ...
                    State st = state;
                    do
                    {
                        solution.add(st);
                        st = st.getParent();
                    }
                    while(st != null);
                }
                else
                {
                    addChildren(state);
                }
            }
        }
        return solution;
    }

    private void addChildren(State state)
    {
        for(int i = 0; i < TABLE_ORDER - 1; i++)
        {
            for(int j = i + 1; j < TABLE_ORDER; j++)
            {
                State childState = getChildState(state, i, j);
                insertInTheRightPosition(childState);
            }
        }
    }

    private State getChildState(State state, int i, int j)
    {
        Integer[] oldPositions = state.getPositions();
        Integer[] positions = new Integer[TABLE_ORDER];
        for(int k = 0; k < TABLE_ORDER; k++)
        {
            positions[k] = k == i? oldPositions[j]: k == j? oldPositions[i]: oldPositions[k];
        }
        return new State(state, positions);
    }

    private void insertInTheRightPosition(State state)
    {
        if(this.toVisit.isEmpty())
        {
            this.toVisit.add(state);
        }
        else
        {
            insertInTheRightPosition(state, 0, this.toVisit.size() - 1);
        }
    }

    private void insertInTheRightPosition(State state, int min, int max)
    {
        int checks = state.numberOfChecks();
        int mid = (min + max) / 2;
        int midChecks = this.toVisit.get(mid).numberOfChecks();
        if(checks == midChecks)
        {
            this.toVisit.add(mid, state);
        }
        else if(min == max)
        {
            if(checks < midChecks)
            {
                this.toVisit.add(max, state);
            }
            else
            {
                this.toVisit.add(max + 1, state);
            }
        }
        else if(max - min == 1)
        {
            int minChecks = this.toVisit.get(min).numberOfChecks();
            int maxChecks = this.toVisit.get(max).numberOfChecks();
            if(checks < minChecks)
            {
                this.toVisit.add(min, state);
            }
            else if(checks > maxChecks)
            {
                this.toVisit.add(max + 1, state);
            }
            else
            {
                this.toVisit.add(max, state);
            }
        }
        else if(checks < midChecks)
        {
            insertInTheRightPosition(state, min, mid);
        }
        else
        {
            insertInTheRightPosition(state, mid, max);
        }
    }
}