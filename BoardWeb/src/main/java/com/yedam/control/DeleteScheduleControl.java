package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.ScheduleVO;

public class DeleteScheduleControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ScheduleVO svo = new ScheduleVO();
		BoardService svc = new BoardServiceImpl();
		
		
		Gson gson = new GsonBuilder().create();
		Map<String, Object> map = new HashMap<>();
		
		if (svc.deleteSchedule(svo)) {
            map.put("retCode", "Success");
            map.put("retVal", svo);

        } else {
            map.put("retCode", "Fail");
            map.put("retVal", null);
        }
		resp.getWriter().print(gson.toJson(map));
	}

}
