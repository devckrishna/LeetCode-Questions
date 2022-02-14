class Solution {
public:
    int ans;
    void findMin(int startAt,int moveCost,int pushCost,vector<int>res){      
        for(int val:res){
            cout<<val<<" ";
        }
        cout<<endl;
        int tempAns=0;
        int index=0;
        for(int i=0;i<res.size();i++){
            if(res[i]==0){
                continue;
            }else{
                index=i;
                break;
            }
        }
        for(index;index<res.size();index++){
            if(res[index]==startAt){
                tempAns+=pushCost;
            }else{
                break;
            }
        }
        for(index;index<res.size();index++){
            tempAns+=pushCost;
            if(index!=0){
                if(res[index]!=res[index-1]){
                    tempAns+=moveCost;
                }
            }else{
                if(res[index]!=startAt){
                    tempAns+=moveCost;
                }
            }
        }
        ans=min(ans,tempAns);
        return;
        
    }
    void solve(int startAt, int moveCost, int pushCost, int targetSeconds,vector<int>res,int buttons){
        if(buttons==4){
            int minutes=res[0]*10+res[1];
            int seconds=res[2]*10+res[3];
            if(minutes*60+seconds==targetSeconds){
                
                findMin(startAt,moveCost,pushCost,res);
            }
            return;
        }
        for(int i=0;i<=9;i++){
            // res[buttons]=i;
            res.push_back(i);
            solve(startAt,moveCost,pushCost,targetSeconds,res,buttons+1);
            res.pop_back();
        }
        return;
    }
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        ans=INT_MAX;
        vector<int>res;
        solve(startAt,moveCost,pushCost,targetSeconds,res,0);
        return ans;
    }
};