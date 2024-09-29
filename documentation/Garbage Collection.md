
Heap Before GC:
+-------+-------+-------+-------+
|  Obj  |  Obj  | Unref |  Obj  |
|   A   |   B   |  Obj  |   C   |
+-------+-------+-------+-------+

Mark Phase:
+-------+-------+-------+-------+
|  Obj  |  Obj  |       |  Obj  |
|   A   |   B   |       |   C   |
+-------+-------+-------+-------+
GC marks referenced objects.

Sweep Phase:
+-------+-------+-------+-------+
|  Obj  |  Obj  |       |  Obj  |
|   A   |   B   |  (freed space)|
+-------+-------+-------+-------+
Unused memory is reclaimed.
