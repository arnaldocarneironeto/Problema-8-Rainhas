package problema.pkg8.rainhas;

import java.util.Arrays;
import static problema.pkg8.rainhas.Constants.TABLE_ORDER;

/**
 *
 * @author Arnaldo Carneiro <acsn@a.recife.ifpe.edu.br>
 */
public class State
{
    private final Integer[] positions;
    private final State parent;

    public State(State parent, Integer[] positions)
    {
        this.positions = positions;
        this.parent = parent;
    }

    public State(State parent, int... positions)
    {
        this.positions = new Integer[TABLE_ORDER];
        this.parent = parent;
        int p;
        for(p = 0; p < Math.min(positions.length, TABLE_ORDER); p++)
        {
            this.positions[p] = positions[p];
        }
        for(; p < TABLE_ORDER; p++)
        {
            this.positions[p] = p;
        }
    }

    public int getPosition(int i)
    {
        return this.positions[i];
    }

    public Integer[] getPositions()
    {
        return positions;
    }

    public State getParent()
    {
        return parent;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 29 * hash + Arrays.hashCode(this.positions);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
        {
            return false;
        }
        final State other = (State) obj;
        return Arrays.deepEquals(this.positions, other.positions);
    }

    private boolean isAtSameDiagonal(int col1, int col2)
    {
        return (this.positions[col1] - col1) == (this.positions[col2] - col2) ||
               (this.positions[col1] + col1) == (this.positions[col2] + col2);
    }
    
    private boolean isAtSameLineOrColumn(int col1, int col2)
    {
        return col1 == col2 || this.positions[col1].equals(this.positions[col2]);
    }

    public final int numberOfChecks()
    {
        int result = 0;
        for(int i = 0; i < TABLE_ORDER - 1; i++)
        {
            for(int j = i + 1; j < TABLE_ORDER; j++)
            {
                if(isAtSameDiagonal(i, j))
                {
                    result++;
                }
                if(isAtSameLineOrColumn(i, j))
                {
                    result++;
                };
            }
        }
        return result;
    }

    @Override
    public String toString()
    {
        String state = "[";
        for(int i = 0; i < TABLE_ORDER; i++)
        {
            state += positions[i];
            if(i < TABLE_ORDER - 1)
            {
                state += ", ";
            }
        }
        state += "]";
        return state;
    }

    public boolean isAncestor(State state)
    {
        boolean result = false;
        State possilbeAncestor = state;
        while(possilbeAncestor != null && result == false)
        {
            result = possilbeAncestor.equals(this);
            possilbeAncestor = possilbeAncestor.getParent();
        }
        return result;
    }

    public boolean isNotSelfAncestor()
    {
        return this.isAncestor(this.getParent()) == false;
    }
}