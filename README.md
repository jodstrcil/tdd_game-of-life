# TDD Kata: Game of Life

Language: Scala

## Description

This Kata is about calculating the next generation of Conway’s game of life, given any starting position. 
See http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life for background.

You start with a two-dimensional grid of cells, where each cell is either alive or dead. In this version of the problem,
the grid is finite, and no life can exist off the edges. When calculating the next generation of the grid, follow these
rules:

   1. Any live cell with fewer than two live neighbours dies (underpopulation)
   2. Any live cell with more than three live neighbours dies (overcrowding)
   3. Any live cell with two or three live neighbours lives on to the next generation
   4. Any dead cell with exactly three live neighbours becomes alive

You should write a program that can accept an arbitrary grid of cells, and will output a similar grid showing the next
generation.

The input starting position could be a text file that looks like this:
```
Generation 1:
4 8
........
....*...
...**...
........
```

The output could look like this:
```
Generation 2:
4 8
........
...**...
...**...
........
```

## Troubleshooting

If SBT fails to import supersafe plugin, check if in your SBT global configuration, the Artima repository is configured: 

File `.sbt/1.0/global.sbt` contains `resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"`
