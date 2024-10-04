board = [["*", "*", "*"],
         ["#", "*", "*"],
         ["*", "*", "-"],
         ["-", "-", "-"],
         ["-", "#", "#"]]

board = [["*", "*", "*"],
         ["-", "*", "*"],
         ["*", "*", "-"],
         ["-", "*", "#"],
         ["-", "#", "#"]]


def soln(board):
    fig_pos = []
    #find position of figures
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j]=="*":
                fig_pos.append([i,j])
    print(fig_pos)

    #sort in decreasing order of row
    fig_pos.sort(key = lambda x:x[0], reverse = True)

    print(fig_pos)

    #couting obstacles
    num_obst = 0

    while True:
        for pos in fig_pos:
            if board[pos[0]+1][pos[1]] == "#":
                board[pos[0]+1][pos[1]] = "-"
                num_obst += 1
                pos[0] = pos[0]+1
            elif board[pos[0]+1][pos[1]] == "-":
                pos[0] = pos[0]+1

        print(fig_pos)
        if fig_pos[0][0] == len(board)-1:
            break

    return num_obst

#soln(board)
                

    
                
                
