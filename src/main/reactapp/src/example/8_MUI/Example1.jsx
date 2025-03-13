//MUI : 리액트.js 기반의 미리 만들어진 컴포넌트들을 제공하는 회사명
//비슷한 회사 : 부트스트랩

//1. MUI 제공하는 컴포넌트 

import Button from '@mui/material/Button';
import Rating from '@mui/material/Rating';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

export default function Example1(){
    return (<>
    <Button variant="text">Text</Button>
    <Rating name="half-rating" defaultValue={2.5} precision={0.5} />
    <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">부서</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          label="부서"
        >
          <MenuItem value={"인사팀"}>인사팀</MenuItem>
          <MenuItem value={"영업팀"}>영업팀</MenuItem>
          <MenuItem value={"개발팀"}>개발팀</MenuItem>
        </Select>
      </FormControl>
    </>)
}