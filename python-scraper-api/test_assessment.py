from collections import Counter

def optimize_transaction_stream(transactions: list[int]) -> list[int]:
    # STEP 1: Fast O(N) frequency calculation using a data-lookup tracking dictionary
    # This generates a map of: { transaction_id: occurrence_count }
    frequency_map = Counter(transactions)
    
    # Extract just the unique transaction keys to prepare for sorting
    unique_ids = list(frequency_map.keys())
    
    # STEP 2: Execute an O(N log N) custom multi-key lambda sort
    # Python sorts lists based on the tuple values provided in the lambda function:
    # Key 1: frequency_map[x] -> Sorts by frequency count in ascending order (Primary Rule)
    # Key 2: -x              -> Placing a negative sign flips sorting to descending numerical order (Tie-Breaker Rule)
    unique_ids.sort(key=lambda x: (frequency_map[x], -x))
    
    return unique_ids

# --- LOCAL VERIFICATION AND TESTING ---
if __name__ == "__main__":
    # Test dataset matching the assessment example prompt
    sample_input = [4, 2, 1, 2, 4, 3, 2]
    
    output_receipt = optimize_transaction_stream(sample_input)
    
    print(f"Input Stream:  {sample_input}")
    print(f"Sorted Result: {output_receipt}")
    # Expected Output: [3, 1, 4, 2]
