#include<iostream>
using namespace std;

struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    int ans;
    int rangeSumBST(TreeNode* root, int L, int R) {
        ans=0;
        rangeHelper(root,L,R);
        return ans;
        
    }
    void rangeHelper(TreeNode* root, int L, int R){
        if(root!=NULL){
            if(L<=root->val && root->val<=R){
                ans+=root->val;
            }
            if(L<root->val){
                rangeHelper(root->left,L,R);
            }
            if(root->val<R){
                rangeHelper(root->right,L,R);
            }
        }
    }
};