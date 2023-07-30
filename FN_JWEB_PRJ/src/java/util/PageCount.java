/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Nguyen Van Ky
 */
public class PageCount {
    public static String hyperlink(String text, String url,String genreid) {
		return "<a class=\"paging_link\" href=\"" + url + "&genreid="+genreid+"\" >" + text + "</a>";
	}

	public static String next(int nextPage,int totalPage,String genreid) {
		nextPage++;
		if(nextPage > totalPage) {
			return "<a class=\"paging_link\">Next</a>";
		}else {
			return "<a class=\"paging_link\" href=\"allmovie?cate_id="+genreid+"&page=" + nextPage + "\">Next</a>";
		}
		
	}

	public static String previous(int previousPage,String genreid) {
		previousPage--;
		if (previousPage == 0) {
			return "<a class=\"paging_link\">Previous</a>";

		}else {
			return "<a class=\"paging_link\" href=\"allmovie?genreid="+genreid+"&page=" + previousPage + "\">Previous</a>";
		}
		
		

	}

	public static String label(String text) {
		return "<span class=\"paging_label\" >" + text + "</span>";
	}

	public static String pager(int gap, int pageindex, int totalpage,String bcid) {
		String result = "";


		if (pageindex - gap > 1) {
			result += hyperlink("First", "?page=1",bcid);
		}

		for (int i = gap; i > 0; i--) {
			int page = pageindex - i;
			if (page > 0) {
				result += hyperlink("" + page, "?page=" + page,bcid);
			}
		}

		result += label(pageindex + "");

		for (int i = 1; i <= gap; i++) {
			int page = pageindex + i;
			if (page <= totalpage) {
				result += hyperlink("" + page, "?page=" + page,bcid);
			}
		}

		if (pageindex + gap < totalpage) {
			result += hyperlink("Last", "?page=" + totalpage,bcid);
		}

		return result;
	}
    
}
