# ➕ Increment Large Integer Problem

## 📋 Problem Description

You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading zeros.

Increment the large integer by one and return the resulting array of digits.

## 💡 Examples

- **Example 1:**
    - Input: `digits = [1, 2, 3]`
    - Output: `[1, 2, 4]`
    - **Explanation**: The array represents the integer `123`. Incrementing by one gives `123 + 1 = 124`. Thus, the result is `[1, 2, 4]`.

- **Example 2:**
    - Input: `digits = [4, 3, 2, 1]`
    - Output: `[4, 3, 2, 2]`
    - **Explanation**: The array represents the integer `4321`. Incrementing by one gives `4321 + 1 = 4322`. Thus, the result is `[4, 3, 2, 2]`.

- **Example 3:**
    - Input: `digits = [9]`
    - Output: `[1, 0]`
    - **Explanation**: The array represents the integer `9`. Incrementing by one gives `9 + 1 = 10`. Thus, the result is `[1, 0]`.

## 📜 Constraints

- The length of `digits` will be between `1` and `10^4`.
- Each element in `digits` is an integer between `0` and `9`.
- The input does not contain leading zeros (except the number 0 itself).

---