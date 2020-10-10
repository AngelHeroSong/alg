
本来以为这周的每日一题全部都是关于二叉树的，结果又回到回溯了，前面刚对回溯做了一个小小的总结[450，什么叫回溯算法，一看就会，一写就废](https://mp.weixin.qq.com/s/yQm53cyiFiJ7NI-lFEa1UA)，今天又是一道关于回溯的题。

### 1，回溯解决
这题和八皇后有点相似，[51. N 皇后](https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-jing-dian-hui-su-suan-fa-tu-wen-xiang-j/)，不同的是八皇后每行只放一个就可以到下一行继续尝试，而这道题每行都放完没有冲突之后才能到下一行继续尝试，所以判断的逻辑稍微比八皇后多一点，但整体思路没差多少
![image.png](https://pic.leetcode-cn.com/1600129403-WSxnVv-image.png)


```
    //回溯算法
    public boolean solveSudoku(char[][] board) {
        return backTrace(board, 0, 0);
    }

    //注意这里的参数，row表示第几行，col表示第几列。
    private boolean backTrace(char[][] board, int row, int col) {
        //注意row是从0开始的，当row等于board.length的时候表示数独的
        //最后一行全部读遍历完了，说明数独中的值是有效的，直接返回true
        if (row == board.length)
            return true;
        //如果当前行的最后一列也遍历完了，就从下一行的第一列开始。这里的遍历
        //顺序是从第1行的第1列一直到最后一列，然后第二行的第一列一直到最后
        //一列，然后第三行的……
        if (col == board.length)
            return backTrace(board, row + 1, 0);
        //如果当前位置已经有数字了，就不能再填了，直接到这一行的下一列
        if (board[row][col] != '.')
            return backTrace(board, row, col + 1);
        //如果上面条件都不满足，我们就从1到9种选择一个合适的数字填入到数独中
        for (char i = '1'; i <= '9'; i++) {
            //判断当前位置[row，col]是否可以放数字i，如果不能放再判断下
            //一个能不能放，直到找到能放的为止，如果从1-9都不能放，就会下面
            //直接return false
            if (!isValid(board, row, col, i))
                continue;
            //如果能放数字i，就把数字i放进去
            board[row][col] = i;
            //如果成功就直接返回，不需要再尝试了
            if (backTrace(board, row, col))
                return true;
            //否则就撤销重新选择
            board[row][col] = '.';
        }
        //如果当前位置[row，col]不能放任何数字，直接返回false
        return false;
    }

    //验证当前位置[row，col]是否可以存放字符c
    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //当前列有没有和字符c重复的
            if (board[i][col] == c)
                return false;
            //当前行有没有和字符c重复的
            if (board[row][i] == c)
                return false;
            //当前的单元格内是否有和字符c重复的
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
```

### 2，位运算解决
位运算是参照这位[Ikaruga](https://leetcode-cn.com/problems/sudoku-solver/solution/37-by-ikaruga/)大佬的。
经常玩数独的可能知道，在填数字的时候一般都是选择那些可填数字比少的位置来填，所以这里也可以使用这种方式。这里为了便于计算，稍微修改了一点，每行每列每个单元格都使用一个int数字来记录，因为int类型是32位，而数独的行和列以及单元格大小都是9，所以使用int来存储足够了，这里只使用int类型的低9位来存储。举个简单的例子，比如第一行已经填了3个数字，比如示例中的5，3，7。那么我们就可以使用一个int类型的数字来表示
![image.png](https://pic.leetcode-cn.com/1600138990-qsKZqp-image.png)

我们来看一下代码
```
       //数独的长宽大小
        final int N = 9;
        //行
        private int[] rows = new int[N];
        //列
        private int[] cols = new int[N];
        //单元格
        private int[][] cells = new int[3][3];

        public void solveSudoku(char[][] board) {
            //统计未填的个数
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    char ch = board[i][j];
                    if (ch == '.') {
                        count++;
                    } else {
                        //如果已经有数字，把这个数字标记一下
                        fillNumber(i, j, ch - '1', true);
                    }
                }
            }
            //上面是一些计算前的准备工作，从这里开始调用回溯算法
            backtrace(board, count);
        }

        private boolean backtrace(char[][] board, int count) {
            //如果可填的位置为0，就是填完了，直接返回true
            if (count == 0) {
                return true;
            }
            //找到可选择数字比较少的位置
            int[] pos = getMinOkMaskCountPos(board);
            int x = pos[0], y = pos[1];
            //获取可选择数字比较少的位置的mask
            int mask = getMask(x, y);
            for (char c = '1'; c <= '9'; c++) {
                int index = c - '1';
                //判断这个位置是否可以填字符c
                if (testMask(mask, index)) {
                    //如果可填，就把字符c填入到这个位置中
                    fillNumber(x, y, index, true);
                    board[x][y] = c;
                    //如果成功直接返回
                    if (backtrace(board, count - 1))
                        return true;
                    //否则，撤销上面的操作
                    board[x][y] = '.';
                    fillNumber(x, y, index, false);
                }
            }
            return false;
        }

        //如果fill是true就把对应位置的数字从右边数第（n+1）位变为1，如果fill为false就把
        //对应位置的数字从右边数第（n+1）位变为0，
        private void fillNumber(int x, int y, int n, boolean fill) {
            if (fill) {
                int mask = 1 << n;
                rows[x] = rows[x] | mask;
                cols[y] = cols[y] | mask;
                cells[x / 3][y / 3] = cells[x / 3][y / 3] | mask;
            } else {
                int mask = ~(1 << n);
                rows[x] = rows[x] & mask;
                cols[y] = cols[y] & mask;
                cells[x / 3][y / 3] = cells[x / 3][y / 3] & mask;
            }
        }

        //当前位置的行，列，单元格进行与运算，运算的结果就是如果这个数字的
        //后面9位哪一个位置是0，就表示这个位置可以填对应的数字
        private int getMask(int x, int y) {
            return rows[x] | cols[y] | cells[x / 3][y / 3];
        }

        //统计上面的方法有多少位置还可以填
        private int getCount(int mask) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) == 0)
                    count++;
            }
            return count;
        }

        //判断mask从右边数第（index+1）个位置是否可以填入数字，
        //注意这里的index是从0开始，如果是0，就表示判断右边第1位
        //能不能填入数字
        private boolean testMask(int mask, int index) {
            return (mask & (1 << index)) == 0;
        }

        //统计所有的单元格，判断哪个单元格内可填数字比较少，就返回哪个单元格的坐标
        private int[] getMinOkMaskCountPos(char[][] board) {
            int[] res = new int[2];
            int min = 10;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.') {
                        int mask = getMask(i, j);
                        int count = getCount(mask);
                        if (count < min) {
                            min = count;
                            res[0] = i;
                            res[1] = j;
                        }
                    }
                }
            }
            return res;
        }

```
再来看一下运行结果，运行结果击败了100%的用户
![image.png](https://pic.leetcode-cn.com/1600139031-tfOuXv-image.png)

<br>

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**

![image.png](https://pic.leetcode-cn.com/d56a80459005b444404d2ad6fbaabdabecd2b9ed3cb2cf432e570c315ae2fcf7-image.png)
##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20200807155236311.png)**”
