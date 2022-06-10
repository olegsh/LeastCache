## "Least Liked" Cache Implementation

We remove the item from Cache which has the least
liked score.

- Cache has a size N
- Each time we make a request to an item in the cache we increase it is likeness
  (we move queue item from current position to the end of queue )
- when we are at the limit of the cache (the cache is full) we must remove the item with least likeness score.
