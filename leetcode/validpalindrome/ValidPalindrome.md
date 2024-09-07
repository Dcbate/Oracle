# 125. Valid Palindrome

---

## Problem Description 📋

A phrase is considered a palindrome if:

- After converting all **uppercase letters** to **lowercase**.
- After removing all **non-alphanumeric characters** (only letters and numbers are considered).

The phrase should read the **same forward and backward** after these operations.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

---

## Examples 📝

### Example 1:
**Input:**  
`s = "A man, a plan, a canal: Panama"`

**Output:**  
`true`

**Explanation:**  
After cleaning the string, it becomes `"amanaplanacanalpanama"`, which is a palindrome.

---

### Example 2:
**Input:**  
`s = "race a car"`

**Output:**  
`false`

**Explanation:**  
After cleaning the string, it becomes `"raceacar"`, which is **not** a palindrome.

---

### Example 3:
**Input:**  
`s = " "`

**Output:**  
`true`

**Explanation:**  
After removing non-alphanumeric characters, `s` becomes an empty string `""`.  
An empty string is considered a palindrome.

---

## Constraints 🔒

- \(1 \leq s.length \leq 2 \times 10^5\)
- `s` consists only of **printable ASCII characters**.

---