# Distinct absolute array elements
## Easy
<div class="problems_problem_content__Xm_eO" style="user-select: auto;"><p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;">Given a sorted&nbsp;array of size N. Count the number of distinct absolute values present in the array.</span><br style="user-select: auto;">
&nbsp;</p>

<p style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></span></p>

<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Input:
</strong>N = 6
Arr[] = {-3, -2, 0, 3, 4, 5}
<strong style="user-select: auto;">Output:</strong> 5
<strong style="user-select: auto;">Explanation:</strong> There are 5 distinct absolute 
values i.e. 0, 2, 3, 4 and 5.</span></pre>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></span></p>

<pre style="user-select: auto;"><span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Input:
</strong>N = 9
Arr[] = {-1, -1, -1, -1, 0, 1, 1, 1, 1}
<strong style="user-select: auto;">Output:</strong> 2
<strong style="user-select: auto;">Explanation:</strong>&nbsp;There are 2 distinct absolute values 
among the elements of this array, i.e. 0 and 1.</span></pre>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Your Task:</strong><br style="user-select: auto;">
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong style="user-select: auto;">distinctCount()</strong>&nbsp;which takes the array of integers&nbsp;<strong style="user-select: auto;">arr[]&nbsp;</strong>and its size&nbsp;<strong style="user-select: auto;">n&nbsp;</strong>as input parameters and returns an integer denoting the answer.</span></p>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Expected Time Complexity:</strong>&nbsp;O(N)<br style="user-select: auto;">
<strong style="user-select: auto;">Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p style="user-select: auto;"><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;"><strong style="user-select: auto;">Constraints:</strong><br style="user-select: auto;">
1 &lt;=<strong style="user-select: auto;"> </strong>N<strong style="user-select: auto;"> </strong>&lt;= 10<sup style="user-select: auto;">5</sup><br style="user-select: auto;">
-10<sup style="user-select: auto;">8</sup>&nbsp;&lt;=<strong style="user-select: auto;"> </strong>Arr[i]<strong style="user-select: auto;"> </strong>&lt;= 10<sup style="user-select: auto;">8</sup></span><br style="user-select: auto;">
<span style="font-size: 18px; user-select: auto;">The array may contain duplicates</span></p>
</div>