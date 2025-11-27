# 8 Queens Problem Solver

A university Artificial Intelligence project from my undergraduate studies, now archived for documentation purposes. This project solves the classic 8 Queens problem using heuristic search algorithms.

## Project Overview

This Java application implements a solution to the 8 Queens Problem, where the goal is to place 8 queens on a chessboard such that no two queens threaten each other. The project demonstrates fundamental AI search techniques with a graphical interface for visualization.

## Algorithm Implementation

The system implements a **Best-First Search** algorithm with the following characteristics:

- **State Representation**: Each state represents a board configuration with queens in different positions
- **Heuristic Function**: Uses the number of queen conflicts (attacks) as the heuristic value
- **Search Strategy**: Maintains a priority queue of states sorted by the number of conflicts
- **State Generation**: Generates child states by swapping queen positions between columns

### Key Algorithmic Features:
- **Avoids Cycles**: Implements ancestor checking to prevent infinite loops
- **Optimal Ordering**: States are inserted in the priority queue based on heuristic value
- **Complete Solution**: Finds a valid configuration with zero conflicts

## Project Structure

```
Problema8Rainhas/
├── src/
│ ├── Problema8Rainhas.java # Main application entry point
│ ├── MainFrame.java # Main GUI frame
│ ├── Puzzle.java # Core search algorithm implementation
│ ├── State.java # State representation and operations
│ ├── StatePanel.java # Visual board representation
│ └── Constants.java # Project constants
└── images/
  ├── chessboard.png # Chessboard background
  └── black queen 2.png # Queen piece visual
```

## Features

- **Interactive Initial State Setup**: Users can configure the starting board position
- **Step-by-Step Visualization**: Slidebar to navigate through the algorithm's execution path
- **Real-time Conflict Calculation**: Visual feedback of queen placements and conflicts
- **Professional UI**: Nimbus Look and Feel for modern appearance

## Technical Implementation

### Core Classes:

1. **Puzzle**: Implements the search algorithm
   - Manages the priority queue of states to visit
   - Generates child states through column swaps
   - Implements best-first search strategy

2. **State**: Represents board configurations
   - Tracks queen positions across 8 columns
   - Calculates heuristic (number of conflicts)
   - Maintains parent state for solution path reconstruction

3. **StatePanel**: Handles visual representation
   - Renders chessboard and queen pieces
   - Updates display based on current state

## Requirements

- Java Runtime Environment (JRE) 8 or higher
- 366x366 pixel display area for the chessboard

## How to Use

1. **Set Initial State**: Configure the starting positions of queens on the board
2. **Run Algorithm**: Click the solve button to initiate the search
3. **Visualize Steps**: Use the slidebar to step through the algorithm's execution
4. **View Solution**: Observe the final state with no conflicting queens

## Algorithm Details

The search algorithm works as follows:

1. Start with initial state in priority queue
2. While queue not empty and solution not found:
   - Remove state with fewest conflicts
   - If zero conflicts: reconstruct and return solution path
   - Else: generate child states by swapping queen positions
   - Insert children into queue sorted by conflict count
3. Return solution path from goal to initial state

## Academic Context

This project was developed for an **Artificial Intelligence** course during my undergraduate studies, demonstrating:
- State-space search algorithms
- Heuristic function design
- Problem representation in AI
- Graph search optimization techniques

## Note on Archival

This repository contains code from my university studies uploaded for archival and documentation purposes. It represents my early work in artificial intelligence and Java development, preserved here to show the progression of my technical skills.

## Developer

**Arnaldo Carneiro**  
University Project - Artificial Intelligence Course

---

*This project was completed as part of my undergraduate curriculum and is uploaded here for historical reference and skill demonstration.*
