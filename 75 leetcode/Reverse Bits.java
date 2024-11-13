public class Solution {
  // Function to reverse the bits of an integer 'n' treated as an unsigned value
  public int reverseBits(int n) {
    int ans = 0;  // This will store the result as we build the reversed bits

    // Loop over all 32 bits of the integer 'n'
    for (int i = 0; i < 32; ++i) {
      // Check if the i-th bit of 'n' is set (1)
      if ((n >> i & 1) == 1)  // Shift 'n' right by 'i' positions and check the least significant bit
        // If the i-th bit is set, set the corresponding bit in the reversed position
        ans |= 1 << (31 - i);  // Left shift '1' to the 31 - i position and OR it with 'ans'
    }

    // Return the reversed bit integer
    return ans;
  }
}
