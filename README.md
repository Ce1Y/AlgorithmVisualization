<!-- this file built by 00957152 -->

# **總述**
    
    此系統提供5種排序演算法的動畫供使用者做使用。
    
        1. Bubble Sort
        2. Insertion Sort
        3. Merge Sort
        4. Quick Sort
        5. Selection Sort
    
    以及Graph區塊提供了Binary Search Tree，
    供使用者做操作與學習。
    
    最後提供排序演算法的題庫，
    讓使用者能夠在學習完排序演算法後做點小練習加深印象。

# **程式區**

    MainFrame
        首頁主要分為2區: Sort and Graph

    Menu
        排序選擇區，選擇你要學習的排序演算法，
        或是點選test進入小測驗。

    VisualizationFrame
        動畫區的功能有:　
        1. START
        2. PAUSE
        3. RESTART
        4. SORT
        5. EXIT
    
    TestInfoFrame
        內有小測驗規則使用說明，
        提供3種題型題提供給使用者做挑戰。

    BSTVisualization
        ADD及Delete支援鍵盤觸發:
        
        其中按下<A>或者<ENTER>可使用ADD
        按下<D>可使用Delete功能

# **src**

    文件區分為5個區塊:
        1. answerSrc
            此package中又分為:
                Insert, Single, True or False，
                分別存放填空、單選、是非題之答案。
        
        2. classSrc
            存放編譯後之class檔
        
        3. imageSrc
            存放所有專案中會使用到的圖片檔，
            包括背景圖片以及bottom上的所有圖片特效。

        4. testSrc
            對應於answerSrc為作答區之題目，
            因方便偵錯，故未將正確答案移除。

        5. textSrc
            存放動畫區右側之5種排序演算法之程式碼。

**補充**

1.  本專案全程使用GitHub做版本控制: 
        <https://github.com/Ce1Y/AlgorithmVisualization>
2.  button上圖片檔來源:
        <https://www.twfont.com/chinese/generator/poster_generator.php>
3.  裁剪圖片: <https://www.iloveimg.com/zh-tw/resize-image>
4.  期末專案PPT:
        <https://docs.google.com/presentation/d/1pJJongITzSdW_VHE3uXtUYz3Zkc2nKT-xAS5fGyyaSI/edit?usp=sharing>

<!--

<https://miro.com/app/board/uXjVOz3bd84=/>

# Cachouuu Branch update:

## version1.0:      2022/6/7
    1. the MainFrame GUI is created on intelliJ.
    2. the structure of this branch renew.
    3. wanna implement Screen Size listener, 
        and resize backgroundImg when screen size changes.
    
## version1.1:      2022/6/8
    1. add Chinese Title, English Title, Sort and Gragh button on MainFrame.
    2. add button listener.
    3. Img source:
        "https://www.twfont.com/chinese/generator/poster_generator.php"
        "https://www.iloveimg.com/zh-tw/resize-image"   

## version1.2:      2022/6/9
    1. change package from ntou.cs.java2022 to classSrc.
    2. write actionPerformed in MainFrame to jump to Frame 1.
    3. design learning frame(add title, code text area, return to menu button)
    4. implement change textFont size of text area.
    5. building SortInfoReader.java to download algorithm code text from txt.
    6. revise InsertionSort.java for readability.

## version1.3:      2022/6/10

>






